import java.util.*;

public class Main {

    static int L, R, C;
    static Tuple start, end;
    static int minTime;
    static boolean[][][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Tuple {
        int z;
        int x;
        int y;
        int min;

        public Tuple(int z, int x, int y, int min) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.min = min;
        }

        public boolean isEnd() {
            return z == end.z && x == end.x && y == end.y;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true) {
            L = s.nextInt();
            R = s.nextInt();
            C = s.nextInt();

            if(L == 0 && R == 0 && C == 0)
                break;

            map = new boolean[L][R][C];
            visited = new boolean[L][R][C];
            minTime = Integer.MAX_VALUE;

            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String str = s.next();
                    for(int k = 0; k < C; k++) {
                        char c = str.charAt(k);

                        if(c == 'S')
                            start = new Tuple(i, j, k, 0);
                        if(c == 'E')
                            end = new Tuple(i, j, k, 0);
                        map[i][j][k] = c == '.' || c == 'E';
                    }
                }
            }

            bfs();
            System.out.println(minTime == Integer.MAX_VALUE ? "Trapped!" : "Escaped in " + minTime + " minute(s).");
        }
    }

    static void bfs() {
        Queue<Tuple> q = new LinkedList<>();
        q.add(start);
        visited[start.z][start.x][start.y] = true;

        while(!q.isEmpty()) {
            Tuple cur = q.poll();

            if(cur.isEnd())
                minTime = Math.min(minTime, cur.min);

            for(int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canMove(nz, nx, ny)) {
                    if(!visited[nz][nx][ny] && map[nz][nx][ny]) {
                        q.add(new Tuple(nz, nx, ny, cur.min+1));
                        visited[nz][nx][ny] = true;
                    }
                }
            }
        }
    }

    static boolean canMove(int z, int x, int y) {
        return x >= 0 && y >= 0 && z >= 0 && x < R && y < C && z < L;
    }
}
