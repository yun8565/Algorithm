import java.util.*;

public class Main {

    static class Pipe {
        int dir; // 0 : 수평 1 : 대각선 2 : 수직
        int x;
        int y;

        public Pipe(int dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] map;
    static int N, cnt = 0;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        map = new boolean[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = s.nextInt() == 0;

        if(map[N-1][N-1])
            bfs();
        System.out.println(cnt);
    }

    static void bfs() {
        Queue<Pipe> q = new LinkedList<>();
        q.add(new Pipe(0, 0, 1));

        while(!q.isEmpty()) {
            Pipe cur = q.poll();

            if(cur.x == N-1 && cur.y == N-1) {
                cnt++;
                continue;
            }

            for(int i = 0; i < 3; i++) {
                if((cur.dir == 0 && i == 2) || (cur.dir == 2 && i == 0))
                    continue;
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < N && ny < N) {
                    if(canGo(i, nx, ny))
                        q.add(new Pipe(i, nx, ny));
                }
            }
        }
    }

    static boolean canGo(int dir, int x, int y) {
        if(dir == 1)
            return map[x][y] && map[x-1][y] && map[x][y-1];
        return map[x][y];
    }
}