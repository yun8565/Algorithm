import java.util.*;

public class Main {
    static final int N = 12, M = 6;
    static char[][] map = new char[N][M];
    static boolean[][] visited = new boolean[N][M];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < N; i++) {
            String input = s.nextLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int chain = 0;

        while(true) {
            int count = 0;
            for(int i = 0; i < N; i++)
                Arrays.fill(visited[i], false);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        if(bfs(i, j))
                            count++;
                    }
                }
            }
            if(count > 0) {
                chain++;
                pop();
            }
            else break;
        }

        System.out.println(chain);
    }

    static boolean bfs(int x, int y) {
        List<Pair> popped = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        visited[x][y] = true;
        Pair start = new Pair(x,y);
        q.add(start);
        popped.add(start);

        int connected = 1;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && map[nx][ny] == map[cur.x][cur.y]) {
                        visited[nx][ny] = true;
                        connected++;
                        Pair next = new Pair(nx, ny);
                        popped.add(next);
                        q.add(next);
                    }
                }
            }
        }
        if(connected >= 4) {
            for(Pair p : popped)
                map[p.x][p.y] = 'x';
            return true;
        }
        return false;
    }

    static void pop() {
        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'x') {
                    int k = 0;
                    int kk = i;
                    while(kk >= 0 && map[kk][j] == 'x') {
                        k++;
                        kk--;
                    }
                    for(int ii = i; ii >= 0; ii--)
                        map[ii][j] = ii-k < 0 ? '.' : map[ii-k][j];
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}