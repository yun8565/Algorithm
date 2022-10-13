import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x, y;
    public Point(int x, int y) {this.x = x; this.y = y;}
}

public class Main {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++)
                maze[i][j] = input.charAt(j) == '1' ? 0 : -1;
        }
        bfs(0,0);
    }

    static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(j,i));
        maze[i][j]++;
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            if(temp.x == M-1 && temp.y == N-1) //출구 도착
                break;

            for (int k = 0; k <= 3; k++) {
                switch(k){
                    case 0 : if(temp.x < M-1 && maze[temp.y][temp.x + 1] >= 0 && !visited[temp.y][temp.x+1]) {
                                q.add(new Point(temp.x + 1, temp.y));
                                maze[temp.y][temp.x+1] = maze[temp.y][temp.x] + 1;
                                visited[temp.y][temp.x+1] = true;
                             } break;
                    case 1 : if(temp.y < N-1 && maze[temp.y+1][temp.x] >= 0 && !visited[temp.y+1][temp.x]) {
                                q.add(new Point(temp.x, temp.y + 1));
                                maze[temp.y+1][temp.x] = maze[temp.y][temp.x] + 1;
                                visited[temp.y+1][temp.x] = true;
                            } break;
                    case 2 : if(temp.x > 0 && maze[temp.y][temp.x - 1] >= 0 && !visited[temp.y][temp.x-1]) {
                                q.add(new Point(temp.x - 1, temp.y));
                                maze[temp.y][temp.x-1] = maze[temp.y][temp.x] + 1;
                                visited[temp.y][temp.x-1] = true;
                            } break;
                    case 3 : if(temp.y > 0 && maze[temp.y-1][temp.x] >= 0 && !visited[temp.y-1][temp.x]) {
                                q.add(new Point(temp.x, temp.y - 1));
                                maze[temp.y-1][temp.x] = maze[temp.y][temp.x] + 1;
                                visited[temp.y-1][temp.x] = true;
                            } break;
                    }
                }
            }
        System.out.println(maze[N-1][M-1]);
    }
}
