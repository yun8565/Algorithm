import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] minWorms;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int[][] farm;
    static boolean[][] visited;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        minWorms = new int[T];

        for(int i = 0; i < T; i++) {
            M = s.nextInt();
            N = s.nextInt();
            int K = s.nextInt();

            farm = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0; j < K; j++) {
                int x = s.nextInt();
                int y = s.nextInt();
                farm[y][x] = 1;
            }

            for(int ii = 0; ii < N; ii++) {
                for(int j = 0; j < M; j++) {
                    if(farm[ii][j] == 1 && !visited[ii][j]) {
                        bfs(ii, j, i);
                        minWorms[i]++;
                    }
                }
            }
        }

        for(int i = 0; i < minWorms.length; i++) {
            System.out.println(minWorms[i]);
        }
    }

    static void bfs(int x, int y, int t) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if(farm[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}