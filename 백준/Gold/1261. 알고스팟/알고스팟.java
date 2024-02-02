import java.util.*;

public class Main {

    static int N, M, minBreak = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        M = s.nextInt();
        N = s.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String input = s.next();
            for (int j = 0; j < M; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        bfs();
        System.out.println(minBreak);
    }

    static void bfs() {
        Queue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1)
                minBreak = Math.min(minBreak, cur.w);

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, map[nx][ny] == 1 ? cur.w+1 : cur.w));
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Pair implements Comparable<Pair> {
        int x,y,w;

        public Pair(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }
}
