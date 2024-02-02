import java.util.*;

public class Main {

    static final int INF = 15*100*100;
    static int n, m, r, maxItems = 0;
    static int[] dist;
    static boolean[] visited;
    static int[] items;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        m = s.nextInt();
        r = s.nextInt();

        graph = new ArrayList[n];
        dist = new int[n];
        items = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            items[i] = s.nextInt();
        }

        for(int i = 0; i < r; i++) {
            int from = s.nextInt()-1;
            int to = s.nextInt()-1;
            int weight = s.nextInt();

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        for(int i = 0; i < n; i++) {
            int count = 0;

            dijkstra(i);

            for(int k = 0; k < n; k++) {
                if(dist[k] <= m)
                    count += items[k];
            }
            maxItems = Math.max(maxItems, count);
        }

        System.out.println(maxItems);
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.v]) {
                visited[cur.v] = true;

                for(Node node : graph[cur.v]) {
                    if(!visited[node.v] && dist[node.v] > dist[cur.v] + node.w) {
                        dist[node.v] = dist[cur.v] + node.w;
                        pq.add(new Node(node.v, dist[node.v]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
