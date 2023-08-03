import java.util.*;

public class Main {

    static int N, M;
    static int[][] iceberg;
    static int[][] melted;
    static boolean allMelted = false;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();

        iceberg = new int[N][M];
        melted = new int[N][M];
        visited = new boolean[N][M];
        int year = 0, piece = 1;

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                iceberg[i][j] = s.nextInt();

        while(true) {
            piece = 0;
            for(int i = 0; i < N; i++) {
                Arrays.fill(melted[i], 0);
                Arrays.fill(visited[i], false);
            }

            for(int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if (!visited[i][j] && iceberg[i][j] > 0) {
                        bfs(i,j);
                        piece++;
                    }
                }
            }
            if(piece > 1)
                break;
            melt();
            if(allMelted)
                break;
            year++;
        }
        System.out.println(allMelted ? 0 : year);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                if(iceberg[cur.x+dx[i]][cur.y+dy[i]] == 0)
                    melted[cur.x][cur.y]--;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (canGo(nx, ny)) {
                    if (!visited[nx][ny] && iceberg[nx][ny] > 0) {
                        q.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void melt() {
        boolean flag = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                iceberg[i][j] = Math.max(0, iceberg[i][j] + melted[i][j]);
                if(iceberg[i][j] != 0)
                    flag = false;
            }
        }
        allMelted = flag;
    }

    static boolean canGo(int nx, int ny) {
        return nx >= 1 && nx < (N-1) && ny >= 1 && ny < (M-1);
    }
}