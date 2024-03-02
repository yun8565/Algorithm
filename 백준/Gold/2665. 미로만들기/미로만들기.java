import java.util.*;

public class Main {

    static int n;
    static int[][] dist;
    static boolean[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        map = new boolean[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++) {
            String input = s.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) == '1';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(dist[n-1][n-1]);
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        dist[0][0] = 0;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx,ny) && dist[nx][ny] > dist[cur.x][cur.y]) {
                    dist[nx][ny] = map[nx][ny] ? dist[cur.x][cur.y] : dist[cur.x][cur.y]+1;
                    q.add(new Pair(nx,ny));
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}