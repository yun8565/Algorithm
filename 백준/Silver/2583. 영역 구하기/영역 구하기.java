import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        M = s.nextInt();
        N = s.nextInt();
        int K = s.nextInt();

        map = new boolean[M][N];
        visited = new boolean[M][N];
        List<Integer> area = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            int y1 = s.nextInt();
            int x1 = s.nextInt();
            int y2 = s.nextInt();
            int x2 = s.nextInt();

            for(int j = x1; j < x2; j++)
                for(int k = y1; k < y2; k++)
                    map[j][k] = true;
        }

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(!map[i][j] && !visited[i][j])
                    area.add(bfs(i, j));

        System.out.println(area.size());
        area.stream().sorted().forEach(a -> System.out.print(a + " "));
    }

    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        int size = 1;
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canMove(nx, ny)) {
                    if(!visited[nx][ny] && !map[nx][ny]) {
                        q.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        size++;
                    }
                }
            }
        }
        return size;
    }

    static boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
