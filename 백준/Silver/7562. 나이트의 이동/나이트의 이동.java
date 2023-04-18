import java.util.*;

public class Main {

    static int L;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int minMove;

    static class Pair {
        int x;
        int y;
        int move;

        public Pair(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            minMove = Integer.MAX_VALUE;
            L = s.nextInt();
            board = new int[L][L];
            visited = new boolean[L][L];

            Pair start = new Pair(s.nextInt(), s.nextInt(), 0);
            Pair goal = new Pair(s.nextInt(), s.nextInt(), 0);
            bfs(start, goal);

            System.out.println(minMove);
        }
    }

    static void bfs(Pair start, Pair goal) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.x == goal.x && cur.y == goal.y)
                minMove = Math.min(minMove, cur.move);

            for(int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny)) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny, cur.move+1));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return 0 <= x && x < L && 0 <= y && y < L;
    }
}