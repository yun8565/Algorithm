import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Pair shark;
    static List<Pair> edibleFish;
    static Pair optimal;
    static int size = 2;
    static int ate = 0;

    static class Pair {
        int x;
        int y;
        int time;

        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int n = s.nextInt();
                if(n == 9)
                    shark = new Pair(i, j, 0);
                else map[i][j] = n;
            }
        }

        while(true) {
            visited = new boolean[N][N];
            edibleFish = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(0 < map[i][j] && map[i][j] < size)
                        edibleFish.add(new Pair(i, j, 0));
                }
            }
            if(edibleFish.size() == 0)
                break;

            optimal = new Pair(0, 0, Integer.MAX_VALUE);
            bfs();
            if(optimal.time == Integer.MAX_VALUE)
                break;

            shark.x = optimal.x;
            shark.y = optimal.y;
            map[optimal.x][optimal.y] = 0;
            shark.time = optimal.time;
            ate++;
            if(ate == size) {
                size++;
                ate = 0;
            }
        }

        System.out.println(shark.time);
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(shark);
        visited[shark.x][shark.y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(canEat(cur.x, cur.y)) {
                if(optimal.time > cur.time)
                    optimal = cur;
                if(optimal.time == cur.time) {
                    if(optimal.x > cur.x)
                        optimal = cur;
                    if(optimal.x == cur.x)
                        optimal = optimal.y > cur.y ? cur : optimal;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && map[nx][ny] <= size) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny, cur.time+1));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static boolean canEat(int x, int y) {
        for(Pair fish : edibleFish) {
            if(x == fish.x && y == fish.y)
                return true;
        }
        return false;
    }
}