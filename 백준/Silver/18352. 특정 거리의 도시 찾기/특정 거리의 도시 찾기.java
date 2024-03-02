import java.util.*;

public class Main {

    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static List<Integer>[] graph;
    static final int INF = 300001;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Queue<Integer> pq = new PriorityQueue<>();

        N = s.nextInt();
        M = s.nextInt();
        int K = s.nextInt();
        int X = s.nextInt();

        dist = new int[N+1];
        visited = new boolean[N+1];
        graph = new List[N+1];
        for(int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            int from = s.nextInt();
            int to = s.nextInt();

            graph[from].add(to);
        }

        dijkstra(X);
        for(int i = 1; i <= N; i++) {
            if(dist[i] == K)
                pq.add(i);
        }
        if(pq.isEmpty())
            System.out.println(-1);
        else {
            while(!pq.isEmpty())
                System.out.println(pq.poll());
        }
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, INF);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(!visited[next] && dist[next] > dist[cur]) {
                    visited[next] = true;
                    dist[next] = dist[cur]+1;
                    q.add(next);
                }
            }
        }
    }
}