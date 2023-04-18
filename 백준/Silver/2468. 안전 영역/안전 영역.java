import java.util.*;

public class Main {

    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxHeight = 0;
    static int maxSafeZone = 0;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();

        area = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int h = s.nextInt();
                maxHeight = Math.max(maxHeight, h);
                area[i][j] = h;
            }
        }

        for(int i = 0; i <= maxHeight; i++) {
            int safeZone = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(area[j][k] > i && !visited[j][k]) {
                        bfs(new Pair(j, k), i);
                        safeZone++;
                    }
                }
            }
            maxSafeZone = Math.max(maxSafeZone, safeZone);
            visited = new boolean[N][N];
        }

        System.out.println(maxSafeZone);
    }

    static void bfs(Pair p, int h) {
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && area[nx][ny] > h) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}