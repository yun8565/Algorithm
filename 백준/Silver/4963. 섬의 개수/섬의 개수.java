import java.util.*;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        while(true){
            w = s.nextInt();
            h = s.nextInt();

            if(w == 0 && h == 0)
                break;

            graph = new int[h][w];
            visited = new boolean[h][w];
            int island = 0;

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++){
                    graph[i][j] = s.nextInt();
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(graph[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        island++;
                    }
                }
            }
            System.out.println(island);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for(int i = 0; i < 8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < h && nextY < w){
                    if(graph[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}