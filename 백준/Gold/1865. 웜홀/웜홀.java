import java.io.*;
import java.util.*;

public class Main {

    static int N, M, W;
    static int[] dist;
    static List<List<Edge>> graph = new ArrayList<>();
    static final int INF = 10000 * 500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            W = Integer.parseInt(input[2]);

            dist = new int[N+1];
            for(int i = 0; i <= N; i++)
                graph.add(new ArrayList<>());

            for(int i = 0; i < M+W; i++) {
                input = br.readLine().split(" ");
                int S = Integer.parseInt(input[0]);
                int E = Integer.parseInt(input[1]);
                int T = Integer.parseInt(input[2]);

                if(i < M) {
                    graph.get(S).add(new Edge(E, T));
                    graph.get(E).add(new Edge(S, T));
                }
                else
                    graph.get(S).add(new Edge(E, -T));
            }

            System.out.println(bellmanFord() ? "YES" : "NO");
            graph.clear();
        }
    }

    static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean flag = false;

        for(int i = 1; i < N; i++) {
            for(int cur = 1; cur <= N; cur++)
                for(Edge next : graph.get(cur)) {
                    if (dist[next.to] > dist[cur] + next.time) {
                        dist[next.to] = dist[cur] + next.time;
                        flag = true;
                    }
                }
            if(!flag)
                break;
        }

        if(flag) {
            for(int cur = 1; cur <= N; cur++) {
                for(Edge next : graph.get(cur))
                    if(dist[next.to] > dist[cur] + next.time)
                        return true;
            }
        }
        return false;
    }

    static class Edge {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
}