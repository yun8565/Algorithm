import java.io.*;
import java.util.*;

public class Main {

    static int R, C, N;
    static boolean[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Pair> q = new LinkedList<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        N = Integer.parseInt(s[2]);

        map = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j) == 'O';
        }
        checkBomb();

       for(int i = 2; i <= N; i++) {
           if(i % 2 == 0)
               fillBomb();
           else {
               explode();
               checkBomb();
           }
        }

        printMap();
        br.close();
    }

    static void explode() {
        int bombs = q.size();
        while(bombs-- > 0) {
            Pair cur = q.poll();
            map[cur.x][cur.y] = false;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(reachable(nx, ny))
                    map[nx][ny] = false;
            }
        }
    }

    static void checkBomb() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j])
                    q.add(new Pair(i, j));
            }
        }
    }

    static void fillBomb() {
        for (boolean[] row : map)
            Arrays.fill(row, true);
    }

    static boolean reachable(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    static void printMap() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(map[i][j] ? "O" : ".");
            }
            System.out.println();
        }
    }
}