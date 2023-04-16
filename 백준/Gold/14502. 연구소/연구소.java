import java.util.*;

public class Main{

    static int N, M;
    static int[][] map;
    static int[][] afterMap;
    static boolean[][] visited;
    static List<Pair> safeZone = new ArrayList<>();
    static List<Pair> virus = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxSafeZone = 0;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        map = new int[N][M];
        afterMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int v = s.nextInt();
                if(v == 0)
                    safeZone.add(new Pair(i, j));
                if(v == 2)
                    virus.add(new Pair(i, j));
                map[i][j] = v;
            }
        }

        for(int i = 0; i < safeZone.size()-2; i++) {
            for(int j = i+1; j < safeZone.size()-1; j++) {
                for(int k = j+1; k < safeZone.size(); k++) {
                    visited = new boolean[N][M];

                    for(int ii = 0; ii < N; ii++)
                        for(int jj = 0; jj < M; jj++)
                            afterMap[ii][jj] = map[ii][jj];

                    Pair wall1 = safeZone.get(i);
                    Pair wall2 = safeZone.get(j);
                    Pair wall3 = safeZone.get(k);

                    afterMap[wall1.x][wall1.y] = 1;
                    afterMap[wall2.x][wall2.y] = 1;
                    afterMap[wall3.x][wall3.y] = 1;

                    for(Pair p : virus)
                        bfs(p);

                    countSafeZone();
                }
            }
        }

        System.out.println(maxSafeZone);
    }

    static void bfs(Pair start) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && afterMap[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        afterMap[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }

    static void countSafeZone() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(afterMap[i][j] == 0)
                    count++;
            }
        }
        maxSafeZone = Math.max(maxSafeZone, count);
    }
}