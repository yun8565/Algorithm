import java.io.*;

public class Main {

    static int R,C;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] visitedAlphabet;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        board = new char[R][C];
        visited = new boolean[R][C];
        visitedAlphabet = new boolean[26];

        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++)
                board[i][j] = input.charAt(j);
        }
        visited[0][0] = true;
        visitedAlphabet[board[0][0] - 'A'] = true;
        dfs(new Pair(0,0), 1);
        System.out.println(maxDist);
    }

    static void dfs(Pair cur, int dist) {
        maxDist = Math.max(maxDist, dist);
        for(int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if(canGo(nx, ny)) {
                if(!visited[nx][ny] && !visitedAlphabet[board[nx][ny] - 'A']) {
                    visited[nx][ny] = true;
                    visitedAlphabet[board[nx][ny] - 'A'] = true;
                    dfs(new Pair(nx, ny), dist+1);
                    visited[nx][ny] = false;
                    visitedAlphabet[board[nx][ny] - 'A'] = false;
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}