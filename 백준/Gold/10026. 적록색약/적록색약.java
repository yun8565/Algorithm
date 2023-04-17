import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static char[][] painting;
    static char[][] painting_for_blind;
    static boolean[][] visited;
    static boolean[][] visited_blind;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        painting = new char[N][N];
        painting_for_blind = new char[N][N];
        visited = new boolean[N][N];
        visited_blind = new boolean[N][N];
        int zone = 0, blindZone = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = s.charAt(j);
                painting_for_blind[i][j] = c;
                painting[i][j] = c;
                if(c == 'G')
                    painting_for_blind[i][j] = 'R';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(new Pair(i, j), false);
                    zone++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited_blind[i][j]) {
                    bfs(new Pair(i, j), true);
                    blindZone++;
                }
            }
        }

        System.out.println(zone + " " + blindZone);
    }

    static void bfs(Pair start, boolean blind) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);

        if(!blind)
            visited[start.x][start.y] = true;
        else
            visited_blind[start.x][start.y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            char color = blind ? painting_for_blind[cur.x][cur.y] : painting[cur.x][cur.y];

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(blind) {
                        if (!visited_blind[nx][ny] && painting_for_blind[nx][ny] == color) {
                            visited_blind[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                    }
                    else {
                        if (!visited[nx][ny] && painting[nx][ny] == color) {
                            visited[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < N;
    }
}