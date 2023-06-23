import java.util.*;

class Solution {
    
    int N;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int[][] computers, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < N; i++) {
                if(cur == i)
                    continue;
                if(!visited[i] && computers[cur][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}