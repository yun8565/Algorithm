import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int K = s.nextInt();

        map = new int[N][M];
        dice = new int[7];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = s.nextInt();

        for(int i = 0; i < K; i++) {
            int dir = s.nextInt();
            int nx = x + dx[dir-1];
            int ny = y + dy[dir-1];

            if(canMove(nx, ny)) {
                roll(dir);
                if(map[nx][ny] == 0)
                    map[nx][ny] = dice[6];
                else {
                    dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                System.out.println(dice[1]);
            }
        }
    }

    static void roll(int dir) {
        int[] temp = dice.clone();
        if(dir == 1) {
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        }
        if(dir == 2) {
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        }
        if(dir == 3) {
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        }
        if(dir == 4) {
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }

    static boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}