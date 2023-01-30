import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int M = s.nextInt();
        int connected = 0;

        graph = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < M; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            graph[u-1][v-1] = 1;
            graph[v-1][u-1] = 1;
        }

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1){
                    cnt++;
                    if(!visited[j]){
                        bfs(j);
                        connected++;
                    }
                }
            }
            if(cnt == 0)
                connected++;
        }

        System.out.println(connected);
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()) {
            x = q.poll();
            for(int i = 0; i < N; i++) {
                if(graph[x][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}