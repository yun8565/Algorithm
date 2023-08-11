import java.util.*;

public class Main {
    static int[] visited = new int[101];
    static int[] map = new int[101];
    static int min;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();

        for(int i = 1; i <= 100; i++)
            map[i] = i;

        for(int i = 0; i < N+M; i++) {
            int from = s.nextInt();
            int to = s.nextInt();
            map[from] = to;
        }

        bfs(1);
        System.out.println(min);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 1; i <= 6; i++) {
                int next = cur + i;

                if(next > 100)
                    continue;

                if(visited[map[next]] == 0) {
                    q.add(map[next]);
                    visited[map[next]] = visited[cur] + 1;
                }

                if(map[next] == 100) {
                    min = visited[100];
                    return;
                }
            }
        }
    }
}