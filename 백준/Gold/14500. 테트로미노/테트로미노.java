import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x;
        int y;
        int depth;
        int score;

        public Pair(int x, int y, int depth, int score) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.score = score;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = s.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int score, int depth) {
        if(depth == 2) {
            for(int i = 0; i < 4; i++) {
                int nx1 = x + dx[i];
                int ny1 = y + dy[i];
                int nx2 = x + dx[(i+1)%4];
                int ny2 = y + dy[(i+1)%4];
                if(canGo(nx1, ny1) && canGo(nx2, ny2)) {
                    if(!visited[nx1][ny1] && !visited[nx2][ny2]) {
                        max = Math.max(max, score + map[nx1][ny1] + map[nx2][ny2]);
                    }
                }
            }
        }
        if(depth == 4) {
            max = Math.max(max, score);
        }
        else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, score+map[nx][ny], depth+1);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}