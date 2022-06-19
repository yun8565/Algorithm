import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] init = r.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        int v = Integer.parseInt(init[2]);

        visit = new boolean[n+1];
        map = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            String[] point = r.readLine().split(" ");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            map[x][y] = 1;
            map[y][x] = 1;
        }
        dfs(v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);
    }

    public static void dfs(int i) {
        visit[i] = true;
        System.out.print(i + " ");
        for(int j=1; j<n+1; j++) {
            if(map[i][j] == 1 && visit[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            for (int j = 1; j < n + 1; j++) {
                if (map[temp][j] == 1 && visit[j] == false) {
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}