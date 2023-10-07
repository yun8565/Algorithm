import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] rain;
    static boolean[][] cloud;
    static boolean[][] tempCloud;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        rain = new int[N][N];
        cloud = new boolean[N][N];
        tempCloud = new boolean[N][N];

        cloud[N-1][0] = true; cloud[N-1][1] = true;
        cloud[N-2][0] = true; cloud[N-2][1] = true;

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                rain[i][j] = Integer.parseInt(line[j]);
        }

        while(M-- > 0) {
            String[] pair = br.readLine().split(" ");
            int d = Integer.parseInt(pair[0])-1;
            int s = Integer.parseInt(pair[1]) % N;

            moveCloud(d, s);
            startRain();
            copyBug();
            makeCloud();
        }

        int sum = Arrays.stream(rain).flatMapToInt(Arrays::stream).sum();
        System.out.println(sum);
    }

    static void moveCloud(int dir, int s) {
        for(int i = 0; i < N; i++)
            Arrays.fill(tempCloud[i], false);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cloud[i][j]) {
                    int nx = ((i + dx[dir] * s) + N) % N;
                    int ny = ((j + dy[dir] * s) + N) % N;
                    tempCloud[nx][ny] = true;
                }
            }
        }
        for(int i = 0; i < N; i++)
            cloud[i] = tempCloud[i].clone();
    }

    static void startRain() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cloud[i][j])
                    rain[i][j]++;
            }
        }
    }

    static void copyBug() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cloud[i][j]) {
                    int check = 0;
                    for(int k = 1; k < 8; k+=2) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(canMove(nx, ny) && rain[nx][ny] != 0)
                            check++;
                    }
                    rain[i][j] += check;
                }
            }
        }
    }

    static void makeCloud() {
        for(int i = 0; i < N; i++)
            Arrays.fill(tempCloud[i], false);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(rain[i][j] >= 2 && !cloud[i][j]) {
                    rain[i][j] -= 2;
                    tempCloud[i][j] = true;
                }
            }
        }
        for(int i = 0; i < N; i++)
            cloud[i] = tempCloud[i].clone();
    }

    static boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}