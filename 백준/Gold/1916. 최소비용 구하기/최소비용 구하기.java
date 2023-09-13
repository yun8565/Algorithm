import java.util.*;

public class Main {

    static int N;
    static final int INF = 100000000;
    static HashMap<Integer, List<Node>> map;
    static int[] minCost;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int M = s.nextInt();

        minCost = new int[N+1];
        visited = new boolean[N+1];
        map = new HashMap<>();

        for(int i = 0; i < M; i++) {
            int from = s.nextInt();
            int to = s.nextInt();
            int cost = s.nextInt();

            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(new Node(to, cost));
        }

        int from = s.nextInt();
        int to = s.nextInt();

        Arrays.fill(minCost, INF);

        System.out.println(dijkstra(from, to));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        minCost[start] = 0;

        while(!pq.isEmpty()) {
            int cur = pq.poll().n;

            if(visited[cur])
                continue;
            visited[cur] = true;

            for(Node next : map.getOrDefault(cur, new ArrayList<>())) {
                if(minCost[next.n] > minCost[cur] + next.dist) {
                    minCost[next.n] = minCost[cur] + next.dist;
                    pq.add(new Node(next.n, minCost[next.n]));
                }
            }
        }

        return minCost[end];
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