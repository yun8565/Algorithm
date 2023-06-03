import java.util.*;

class Solution {
    
    class Pair {
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Pair(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            if(cur.x == n-1 && cur.y == m-1) {
                answer = Math.min(answer, cur.dist);   
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        q.add(new Pair(nx, ny, cur.dist+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}