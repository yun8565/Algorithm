import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] isLand;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDist = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();

        isLand = new boolean[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = s.next();
            for(int j = 0; j < M; j++) {
                isLand[i][j] = str.charAt(j) == 'L';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(isLand[i][j]) {
                    for(int k = 0; k < N; k++)
                        Arrays.fill(visited[k], -1);
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxDist);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visited[x][y] = 0;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(visited[nx][ny] < 0 && isLand[nx][ny]) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        int max = Arrays.stream(visited).flatMapToInt(Arrays::stream).max().orElse(0);
        maxDist = Math.max(maxDist, max);
    }

    static class Pair{
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}