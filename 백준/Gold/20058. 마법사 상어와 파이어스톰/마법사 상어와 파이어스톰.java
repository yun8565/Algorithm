import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, rotateMap;
    static boolean[][] visited;
    static int N, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = (int)Math.pow(2, Integer.parseInt(input[0]));
        int Q = Integer.parseInt(input[1]);

        map = new int[N][N];
        rotateMap = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < Q; i++) {
            firestorm(Integer.parseInt(input[i]));
            checkAndMelt();
        }

        int sum = Arrays.stream(map).flatMapToInt(Arrays::stream).sum();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > 0)
                    bfs(i, j);
            }
        }
        System.out.println(sum);
        System.out.println(max);
    }

    static void firestorm(int L) {
        int pow = (int)Math.pow(2, L);
        for(int i = 0; i < N; i += pow) {
            for(int j = 0; j < N; j += pow) {
                rotate(i,j,pow);
            }
        }
        for(int i = 0; i < N; i++)
            map[i] = rotateMap[i].clone();
        for(int i = 0; i < N; i++)
            Arrays.fill(rotateMap[i], 0);
    }

    static void rotate(int x, int y, int pow) {
        for(int i = 0; i < pow; i++) {
            for(int j = 0; j < pow; j++) {
                rotateMap[i+x][j+y] = map[pow-j-1+x][i+y];
            }
        }
    }

    static void checkAndMelt() {
        Queue<Pair> melt = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int exposed = 0;
                for(int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(canGo(nx, ny))
                        if(map[nx][ny] > 0)
                            continue;
                    exposed++;
                }
                if(exposed >= 2)
                    melt.add(new Pair(i,j));
            }
        }
        while(!melt.isEmpty()) {
            Pair ice = melt.poll();
            map[ice.x][ice.y] = Math.max(0, map[ice.x][ice.y]-1);
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Pair(x, y));
        int cnt = 1;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && map[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        max = Math.max(max, cnt);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}