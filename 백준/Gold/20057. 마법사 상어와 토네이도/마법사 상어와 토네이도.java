import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] cur;
    static int sandGone = 0, dir = 0, dist = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        cur = new int[]{N/2, N/2};
        tornado();
        System.out.println(sandGone);
    }

    static void tornado() {
        while(true) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < dist; k++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if (canGo(nx, ny)) {
                        moveSand(nx, ny);
                        cur[0] = nx;
                        cur[1] = ny;
                        if(cur[0] == 0 && cur[1] == 0)
                            return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            dist++;
        }
    }

    static void moveSand(int x, int y) {
        int sand = map[x][y];
        int left = sand;

        if(dir%2 == 0) {
            if (canGo(x-1, y + dy[(dir + 2) % 4]))
                map[x-1][y + dy[(dir + 2) % 4]] += sand /100;
            else
                sandGone += sand /100;
            left -= sand/100;

            if (canGo(x+1, y + dy[(dir + 2) % 4]))
                map[x+1][y + dy[(dir + 2) % 4]] += sand /100;
            else
                sandGone += sand /100;
            left -= sand /100;
        }
        else {
            if(canGo(x+dx[(dir+2)%4], y+1))
                map[x + dx[(dir + 2) % 4]][y + 1] += sand /100;
            else
                sandGone += sand /100;
            left -= sand /100;

            if(canGo(x+dx[(dir+2)%4], y-1))
                map[x + dx[(dir + 2) % 4]][y-1] += sand /100;
            else
                sandGone += sand /100;
            left -= sand /100;
        }

        if(canGo(x+dx[(dir+1)%4], y+dy[(dir+1)%4]))
            map[x + dx[(dir + 1) % 4]][y+dy[(dir+1)%4]] += (sand*7)/100;
        else
            sandGone += (sand*7)/100;
        left -= (sand*7)/100;

        if(canGo(x+dx[(dir+3)%4], y+dy[(dir+3)%4]))
            map[x + dx[(dir + 3) % 4]][y+dy[(dir+3)%4]] += (sand*7)/100;
        else
            sandGone += (sand*7)/100;
        left -= (sand*7)/100;

        if(canGo(x+(dx[(dir+1)%4]*2), y+(dy[(dir+1)%4]*2)))
            map[x + (dx[(dir + 1) % 4] * 2)][y+(dy[(dir+1)%4]*2)] += (sand*2)/100;
        else
            sandGone += (sand*2)/100;
        left -= (sand*2)/100;

        if(canGo(x+(dx[(dir+3)%4]*2), y+(dy[(dir+3)%4]*2)))
            map[x + (dx[(dir + 3) % 4] * 2)][y+(dy[(dir+3)%4]*2)] += (sand*2)/100;
        else
            sandGone += (sand*2)/100;
        left -= (sand*2)/100;

        if(dir%2==0) {
            if (canGo(x+1, y + dy[dir]))
                map[x+1][y + dy[dir]] += sand /10;
            else
                sandGone += sand /10;
            left -= sand /10;

            if (canGo(x-1, y + dy[dir]))
                map[x-1][y + dy[dir]] += sand /10;
            else
                sandGone += sand /10;
            left -= sand /10;
        }
        else {
            if (canGo(x + dx[dir], y+1))
                map[x + dx[dir]][y+1] += sand /10;
            else
                sandGone += sand /10;
            left -= sand /10;

            if (canGo(x + dx[dir], y-1))
                map[x + dx[dir]][y-1] += sand /10;
            else
                sandGone += sand /10;
            left -= sand /10;
        }

        if(canGo(x+(dx[dir]*2), y+(dy[dir]*2)))
            map[x+(dx[dir]*2)][y+(dy[dir]*2)] += (sand*5)/100;
        else
            sandGone += (sand*5)/100;
        left -= (sand*5)/100;

        if(canGo(x+dx[dir], y + dy[dir]))
            map[x+dx[dir]][y+dy[dir]] += left;
        else
            sandGone += left;
        map[x][y] = 0;
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}