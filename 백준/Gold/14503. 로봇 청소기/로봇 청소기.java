import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] room;
    static boolean[][] cleaned;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Robot robot;

    static class Robot {
        int x;
        int y;
        int dir;
        int clean;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.clean = 0;
        }
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        room = new boolean[N][M];
        cleaned = new boolean[N][M];

        int r = s.nextInt();
        int c = s.nextInt();
        int dir = s.nextInt();
        robot = new Robot(r, c, dir);

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                room[i][j] = s.nextInt() == 0;
        }

        while(true) {
            if(!cleaned[robot.x][robot.y]) {
                cleaned[robot.x][robot.y] = true;
                robot.clean++;
            }
            else if(hasNearBy()) {
                robot.dir = (robot.dir+3)%4;
                int nx = robot.x + dx[robot.dir];
                int ny = robot.y + dy[robot.dir];
                if(canGo(nx, ny) && !cleaned[nx][ny]) {
                    robot.x = nx;
                    robot.y = ny;
                }
            }
            else {
                if(canGoBack()) {
                    robot.x += dx[(robot.dir+2)%4];
                    robot.y += dy[(robot.dir+2)%4];
                }
                else break;
            }
        }

        System.out.println(robot.clean);
    }

    static boolean canGoBack() {
        return canGo(robot.x+dx[(robot.dir+2)%4], robot.y+dy[(robot.dir+2)%4]);
    }

    static boolean hasNearBy() {
        for(int i = 0; i < 4; i++) {
            int nx = robot.x + dx[i];
            int ny = robot.y + dy[i];
            if(canGo(nx, ny)) {
                if(room[nx][ny] && !cleaned[nx][ny])
                    return true;
            }
        }
        return false;
    }

    static boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M && room[x][y];
    }
}