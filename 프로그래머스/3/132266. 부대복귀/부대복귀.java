import java.util.*;

class Solution {
    
    boolean[] visited;
    int[] dist;
    ArrayList<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] road : roads) {
            int a1 = road[0];
            int a2 = road[1];
            
            graph[a1].add(a2);
            graph[a2].add(a1);
        }
        
        dijkstra(destination);
        
        for(int i = 0; i < sources.length; i++)
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        
        return answer;
    }
    
    void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.add(start);
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : graph[cur]) {
                if(dist[next] > dist[cur]+1) {
                    dist[next] = dist[cur]+1;
                    q.add(next);
                }
            }    
        }
    }
}