import java.util.*;

public class Main {

    static int N;
    static int[] minDist;
    static boolean[] visited;
    static HashMap<Integer, List<Node>> map;
    static final int INF = 200000000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int E = s.nextInt();
        minDist = new int[N+1];
        visited = new boolean[N+1];
        map = new HashMap<>();

        for(int i = 0; i < E; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();

            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(new Node(b, c));
            map.get(b).add(new Node(a, c));
        }

        int v1 = s.nextInt();
        int v2 = s.nextInt();

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        System.out.println(Math.min(result1, result2) >= INF ? -1 : Math.min(result1, result2));
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(minDist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        minDist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.n]) {
                visited[cur.n] = true;

                for(Node node : map.getOrDefault(cur.n, new ArrayList<>())) {
                    if(!visited[node.n] && minDist[node.n] > minDist[cur.n] + node.dist) {
                        minDist[node.n] = minDist[cur.n] + node.dist;
                        pq.add(new Node(node.n, minDist[node.n]));
                    }
                }
            }
        }

        return minDist[end];
    }

    static class Node implements Comparable<Node> {
        int n;
        int dist;

        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}