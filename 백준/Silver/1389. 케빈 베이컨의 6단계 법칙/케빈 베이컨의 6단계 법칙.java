import java.util.*;

public class Main {

    static int N;
    static boolean[][] friend;
    static boolean[][] visited;

    static class Pair {
        int x;
        int depth;

        public Pair(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int M = s.nextInt();

        friend = new boolean[N+1][N+1];
        visited = new boolean[N+1][N+1];
        int minKevinBacon = Integer.MAX_VALUE;
        int minPerson = 0;

        for(int i = 0; i < M; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            friend[x][y] = true;
            friend[y][x] = true;
        }

        for(int i = 1; i <= N; i++) {
            int kevinBacon = bfs(i);
            if(kevinBacon < minKevinBacon) {
                minKevinBacon = kevinBacon;
                minPerson = i;
            }
        }

        System.out.println(minPerson);
    }

    static int bfs(int k) {
        Queue<Pair> q = new LinkedList<>();
        int[] kevinBacon = new int[N];
        q.add(new Pair(k, 1));

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 1; i <= N; i++) {
                if(i == cur.x || i == k)
                    continue;
                if(friend[cur.x][i] && kevinBacon[i-1] == 0) {
                    kevinBacon[i-1] = cur.depth;
                    q.add(new Pair(i, cur.depth+1));
                }
            }
        }
        return Arrays.stream(kevinBacon).sum();
    }
}