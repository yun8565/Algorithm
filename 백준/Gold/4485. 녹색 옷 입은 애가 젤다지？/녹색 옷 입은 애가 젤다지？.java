import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] minCost;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for(int t = 1;; t++) {
            N = s.nextInt();
            if(N == 0)
                break;

            map = new int[N][N];
            minCost = new int[N][N];

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.nextInt();
                    minCost[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();

            System.out.printf("Problem %d: %d\n", t, minCost[N-1][N-1]);
        }
    }

    static void dijkstra() {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        minCost[0][0] = map[0][0];
        pq.offer(new Pair(0,0, map[0][0]));

        while(!pq.isEmpty()) {
            Pair cur = pq.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(minCost[nx][ny] > minCost[cur.x][cur.y] + map[nx][ny]) {
                        minCost[nx][ny] = minCost[cur.x][cur.y] + map[nx][ny];
                        pq.add(new Pair(nx, ny, minCost[nx][ny]));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}