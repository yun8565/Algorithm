import java.util.*;

public class Main {

    static int N, M, size = 0;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

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

        cheese = new int[N][M];
        visited = new boolean[N][M];
        int time = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cheese[i][j] = s.nextInt();
                if(cheese[i][j] == 1)
                    size++;
            }
        }

        while(size > 0) {
            boolean flag = false;
            for(int i = 0; i < N; i++)
                Arrays.fill(visited[i], false);

            for (int i = 0; i < N; i++) {
                if(flag) break;
                for (int j = 0; j < M; j++)
                    if(cheese[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j);
                        flag = true;
                    }
            }
            melt();
            time++;
        }

        System.out.println(time);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(!visited[nx][ny]) {
                        if(cheese[nx][ny] >= 1)
                            cheese[nx][ny]++;
                        else {
                            visited[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static void melt() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cheese[i][j] > 2) {
                    cheese[i][j] = 0;
                    size--;
                }
                else if(cheese[i][j] > 1)
                    cheese[i][j] = 1;
            }
        }
    }
}