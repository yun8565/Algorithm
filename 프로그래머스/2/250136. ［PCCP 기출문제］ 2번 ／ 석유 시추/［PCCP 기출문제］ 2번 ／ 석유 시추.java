import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[][] map;
    List<Integer> oilSize = new ArrayList<>();
    int N, M, answer = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        map = land;
        visited = new boolean[N][M];
        int num = 2;
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[j][i] && map[j][i] == 1)
                    oilSize.add(bfs(j,i, num++));
            }    
        }
        
        boolean accessible[] = new boolean[oilSize.size()];
        
        for(int i = 0; i < M; i++) {
            int sum = 0;
            Arrays.fill(accessible, false);
            for(int j = 0; j < N; j++) {
                if(map[j][i] > 1)
                    accessible[map[j][i]-2] = true;
            }
            for(int k = 0; k < accessible.length; k++) {
                if(accessible[k])
                    sum += oilSize.get(k);
            }
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    int bfs(int x, int y, int num) {
        Queue<Pair> q = new LinkedList<>();
        visited[x][y] = true;
        map[x][y] = num;
        int size = 1;
        q.add(new Pair(x,y));
        
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            map[cur.x][cur.y] = num;
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(canGo(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    size++;
                    q.add(new Pair(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }
    
    boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    
    class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}