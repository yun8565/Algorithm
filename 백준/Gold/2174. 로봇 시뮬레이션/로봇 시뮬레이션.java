import java.io.*;
import java.util.*;

public class Main {

    static int A, B;
    static int[][] map;
    // E S W N
    static HashMap<String, Integer> dirMap = new HashMap<>() {{
            put("E", 0); put("S", 1); put("W", 2); put("N", 3);
    }};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Pair[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new int[A][B];
        robots = new Pair[N];
        boolean flag = true;

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            String dir = input[2];

            robots[i] = new Pair(x, y, (dirMap.get(dir)+1) % 4);
            map[x][y] = i+1;
        }

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]) - 1;
            String op = input[1];
            int repeat = Integer.parseInt(input[2]);

            while(repeat-- > 0 && flag) {
                flag = simulate(index, op);
            }
        }
        if(flag)
            System.out.println("OK");
    }

    static boolean simulate(int i, String op) {
        if(op.equals("F")) {
            int nx = robots[i].x + dx[robots[i].dir];
            int ny = robots[i].y + dy[robots[i].dir];
            if(nx < 0 || ny < 0 || nx >= A || ny >= B) {
                System.out.println("Robot "+(i+1)+" crashes into the wall");
                return false;
            }
            if(map[nx][ny] > 0) {
                System.out.println("Robot "+(i+1)+" crashes into robot "+map[nx][ny]);
                return false;
            }
            map[robots[i].x][robots[i].y] = 0;
            map[nx][ny] = i+1;
            robots[i].x = nx;
            robots[i].y = ny;
        }
        else
            robots[i].dir = op.equals("L") ? (robots[i].dir + 3) % 4 : (robots[i].dir + 1) % 4;

        return true;
    }

    static class Pair {
        int x, y;
        int dir;

        public Pair(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}