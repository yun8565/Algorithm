import java.util.*;

class Solution {
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int answer = 0;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int[][] filled = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        Queue<Pair> q = new LinkedList<>();
        
        for(int[] rect : rectangle) {
            for(int x = rect[0]*2; x <= rect[2]*2; x++) {
                for(int y = rect[1]*2; y <= rect[3]*2; y++) {
                    if(filled[x][y] == 2)
                        continue;
                    filled[x][y] = 2;
                    if(x == rect[0]*2 || x == rect[2]*2 || y == rect[1]*2 || y == rect[3]*2)
                        filled[x][y] = 1;
                }
            }
        }
        
        filled[characterX*2][characterY*2] = 1;
        filled[itemX*2][itemY*2] = 1;
        
        q.add(new Pair(characterX*2, characterY*2, 0));
        visited[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            
            if(cur.x == itemX*2 && cur.y == itemY*2) {
                answer = cur.len/2;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx,ny)) {
                    if(!visited[nx][ny] && filled[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny, cur.len+1));
                    }
                }
            }
        }
        return answer;
    }
    
    boolean canGo(int x, int y) {
        return x > 0 && y > 0 && x <= 100 && y <= 100;
    }
    
    class Pair {
        int x,y, len;
        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}