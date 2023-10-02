import java.io.*;

public class Main {

    static boolean[][] apple;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, dir = 0;
    static int[] head = {0,0}, tail = {0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int time = 0;

        apple = new boolean[N][N];
        visited = new int[N][N];
        visited[0][0] = 1;

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            apple[x][y] = true;
        }

        int L = Integer.parseInt(br.readLine());
        boolean flag = true;
        
        game : for(int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            boolean left = input[1].equals("L");

            while(time < X) {
                time++;
                flag = move();
                if(!flag)
                    break game;
            }
            dir = left ? (dir+3) % 4 : (dir+1) % 4;
            visited[head[0]][head[1]] = dir+1;
        }
        while(flag) {
            time++;
            flag = move();
        }
        System.out.println(time);
    }

    static boolean move() {
        int nx = head[0] + dx[dir];
        int ny = head[1] + dy[dir];
        if(canGo(nx, ny)) {
            if(visited[nx][ny] == 0) {
                head[0] = nx;
                head[1] = ny;
                visited[nx][ny] = dir+1;
                if(!apple[nx][ny]) {
                    int x = tail[0] + dx[visited[tail[0]][tail[1]]-1];
                    int y = tail[1] + dy[visited[tail[0]][tail[1]]-1];
                    visited[tail[0]][tail[1]] = 0;
                    tail[0] = x;
                    tail[1] = y;
                }
                else
                    apple[nx][ny] = false;
                return true;
            }
        }
        return false;
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}