import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, maxSafetyZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        int max = Arrays.stream(map).flatMapToInt(Arrays::stream)
                .max().orElse(1);

        for(int depth = 0; depth <= max; depth++) {
            int safetyZone = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] > depth) {
                        bfs(i, j, depth);
                        safetyZone++;
                    }
                }
            }
            maxSafetyZone = Math.max(maxSafetyZone, safetyZone);
            for(int i = 0; i < N; i++)
                Arrays.fill(visited[i], false);
        }

        System.out.println(maxSafetyZone);
    }

    static void bfs(int x, int y, int depth) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(canGo(nx,ny)) {
                    if(!visited[nx][ny] && map[nx][ny] > depth) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx,ny));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}