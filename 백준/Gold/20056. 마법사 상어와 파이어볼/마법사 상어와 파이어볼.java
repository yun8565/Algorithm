import java.util.*;

public class Main {

    static int N;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Fireball>[][] map;
    static List<Fireball> fireballs = new ArrayList<>();

    static class Fireball {
        int x;
        int y;
        int m;
        int s;
        int d;

        public Fireball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void move() {
            x = (N + x + dx[d] * (s % N)) % N;
            y = (N + y + dy[d] * (s % N)) % N;
            map[x][y].add(this);
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();

        map = new Queue[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < M; i++) {
            int x = s.nextInt()-1;
            int y = s.nextInt()-1;
            int m = s.nextInt();
            int sp = s.nextInt();
            int d = s.nextInt();
            fireballs.add(new Fireball(x,y,m,sp,d));
        }

        for(int i = 0; i < K; i++) {
            fireballs.forEach(Fireball::move);
            mergeAndDivide();
        }

        System.out.println(fireballs.stream().mapToInt(f -> f.m).sum());
    }

    static void mergeAndDivide() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].size() > 1) {
                    int totalM = 0, totalS = 0;
                    int cnt = map[i][j].size();
                    boolean odd = true, even = true;

                    while(!map[i][j].isEmpty()) {
                        Fireball cur = map[i][j].poll();
                        totalM += cur.m;
                        totalS += cur.s;
                        if(cur.d % 2 == 0) odd = false;
                        else even = false;

                        fireballs.remove(cur);
                    }

                    int newM = totalM / 5;
                    if(newM == 0)
                        continue;
                    int newS = totalS / cnt;
                    if(odd | even)
                        for(int k = 0; k <= 6; k += 2)
                            fireballs.add(new Fireball(i,j,newM,newS,k));
                    else
                        for(int k = 1; k <= 7; k += 2)
                            fireballs.add(new Fireball(i,j,newM,newS,k));
                }
                else
                    map[i][j].clear();
            }
        }
    }
}