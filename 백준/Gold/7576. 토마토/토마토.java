import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N,M, day = 0;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        M = Integer.parseInt(NM[0]);
        N = Integer.parseInt(NM[1]);

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(input[j]);
                if(num == 1)
                    q.add(new Pair(i, j));
                map[i][j] = num;
            }
        }

        bfs();
        System.out.println(isOver() ? day : -1);
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(canGo(nx,ny) && map[nx][ny] == 0) {
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        day = Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .max().orElse(0)-1;
    }

    static boolean isOver() {
        return Arrays.stream(map).flatMapToInt(Arrays::stream)
                .allMatch(tomato -> tomato!=0);
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}