import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.k, o2.k));

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int K = s.nextInt();

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int virus = s.nextInt();
                if(virus > 0)
                    pq.add(new Pair(i,j,virus));
                map[i][j] = virus;
            }
        }

        int S = s.nextInt();
        int X = s.nextInt()-1;
        int Y = s.nextInt()-1;

        while(S-- > 0) {
            bfs();
        }

        System.out.println(map[X][Y]);
    }

    static void bfs() {
        List<Pair> newVirus = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
                    map[nx][ny] = cur.k;
                    newVirus.add(new Pair(nx, ny, cur.k));
                }
            }
        }
        pq.addAll(newVirus);
    }

    static class Pair {
        int x,y,k;
        public Pair(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}