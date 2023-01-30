import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int apartNum = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] aparts;
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        aparts = new int[N*N];
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String input = s.next();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);
        for(int i = 0; i < aparts.length; i++) {
            if(aparts[i] != 0)
                System.out.println(aparts[i]);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        aparts[apartNum]++;

        while(!q.isEmpty()){
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N){
                    if(map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        aparts[apartNum]++;
                    }
                }
            }
        }
    }
}