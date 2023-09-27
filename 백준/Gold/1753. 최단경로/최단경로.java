import java.util.*;

public class Main {

    static final int INF = 3000000;
    static int V;
    static int[] minDist;
    static boolean[] visited;
    static HashMap<Integer, List<Node>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        V = s.nextInt();
        int E = s.nextInt();
        int start = s.nextInt() - 1;

        minDist = new int[V];
        visited = new boolean[V];

        for(int i = 0; i < E; i++) {
            int u = s.nextInt()-1;
            int v = s.nextInt()-1;
            int w = s.nextInt();

            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(new Node(v,w));
        }

        dijkstra(start);

        for(int i = 0; i < V; i++) {
            System.out.println(minDist[i] == INF ? "INF" : minDist[i]);
        }
    }

    static void dijkstra(int start) {
        Arrays.fill(minDist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        minDist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.to]) {
                visited[cur.to] = true;

                for(Node node : map.getOrDefault(cur.to, new ArrayList<>())) {
                    if(!visited[node.to] && minDist[node.to] > minDist[cur.to] + node.dist) {
                        minDist[node.to] = minDist[cur.to] + node.dist;
                        pq.add(new Node(node.to, minDist[node.to]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to, dist;
        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}