import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean canOpen(int x, int y) {
            return Math.abs(A[x][y] - A[this.x][this.y]) >= L && Math.abs(A[x][y] - A[this.x][this.y]) <= R;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        L = s.nextInt();
        R = s.nextInt();

        A = new int[N][N];
        boolean flag;
        int day = -1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                A[i][j] = s.nextInt();
            }
        }

        do {
            flag = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    if(!visited[i][j])
                        flag |= move(i, j);
            day++;
        } while(flag);
        System.out.println(day);
    }

    static boolean move(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        List<Pair> union = new ArrayList<>();
        int population = A[x][y];

        q.add(new Pair(x, y));
        union.add(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && cur.canOpen(nx, ny)) {
                        q.add(new Pair(nx, ny));
                        union.add(new Pair(nx, ny));
                        population += A[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        for(Pair p : union)
            A[p.x][p.y] = population / union.size();
        
        return union.size() > 1;
    }

    static boolean canGo(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}