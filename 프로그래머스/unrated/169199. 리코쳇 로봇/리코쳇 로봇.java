import java.util.*;

class Solution {
    
    class Pair {
        int x;
        int y;
        int moved;

        public Pair(int x, int y, int moved) {
            this.x = x;
            this.y = y;
            this.moved = moved;
        }
    }
    
    boolean[][] map;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Pair goal;
    int min = Integer.MAX_VALUE;
    
    public int solution(String[] board) {
        map = new boolean[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        int n = board.length;
        int m = board[0].length();

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String s = board[i];
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == 'R') {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
                if(s.charAt(j) == 'G')
                    goal = new Pair(i, j, 0);
                if(s.charAt(j) != 'D')
                    map[i][j] = true;
            }
        }

        //bfs
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int cnt = cur.moved;

            if(isGoal(cur.x, cur.y))
                min = Math.min(min, cnt);

            for(int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;

                while(0 <= nx+dx[i] && nx+dx[i] < n && 0 <= ny+dy[i] &&
                        ny+dy[i] < m && map[nx+dx[i]][ny+dy[i]]) {
                    nx += dx[i];
                    ny += dy[i];
                }
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, cnt+1));
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public boolean isGoal(int x, int y) {
        return x == goal.x && y == goal.y;
    }
}