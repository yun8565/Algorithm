import java.util.*;

public class Main {

    static int N, M, T;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int minTime = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        T = s.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = s.nextInt();

        bfs();
        System.out.println(minTime == Integer.MAX_VALUE ? "Fail" : minTime);
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.time > T)
                break;

            if(cur.x == N-1 && cur.y == M-1)
                minTime = Math.min(minTime, cur.time);

            if(map[cur.x][cur.y] == 2) {
                int distance = N-1-cur.x + M-1-cur.y;
                if(T-cur.time >= distance)
                    minTime = Math.min(minTime, cur.time + distance);
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(inMap(nx, ny)) {
                    if(!visited[nx][ny] && map[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny, cur.time+1));
                    }
                }
            }
        }
    }

    static boolean inMap(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Pair {
        int x,y,time;
        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}