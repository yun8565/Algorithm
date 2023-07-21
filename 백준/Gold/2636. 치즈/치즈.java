import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] cheese;
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

        cheese = new boolean[N][M];
        int time = 0, left = 0;

        for(int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                cheese[i][j] = s.nextInt() == 1;

        while(!isEmpty()) {
            visited = new boolean[N][M];
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if(flag) break;
                for (int j = 0; j < M; j++) {
                    if (!cheese[i][j] && !visited[i][j]) {
                        left = bfs(i, j);
                        flag = true;
                        break;
                    }
                }
            }
            time++;
        }

        System.out.println(time);
        System.out.println(left);
    }

    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;
        int exposed = 0;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(!visited[nx][ny]) {
                        if(cheese[nx][ny]) {
                            visited[nx][ny] = true;
                            cheese[nx][ny] = false;
                            exposed++;
                        }
                        else {
                            visited[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        return exposed;
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static boolean isEmpty() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(cheese[i][j])
                    return false;

        return true;
    }
}