import java.util.*;

class Solution {
    
    public int[] dx = {1, 0, 0, -1};
        public int[] dy = {0, -1, 1, 0};
        public String[] ds = {"d", "l", "r", "u"};

        static public class Point {
            public int x, y;
            public StringBuilder sb;

            public Point(int x, int y, StringBuilder sb) {
                this.x = x;
                this.y = y;
                this.sb = sb;
            }
        }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] chk = new boolean[n][m][k+1];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x-1, y-1, new StringBuilder()));
        chk[x-1][y-1][0] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.sb.toString().length() == k) {
                if(cur.x == r-1 && cur.y == c-1)
                    return cur.sb.toString();
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || chk[nx][ny][cur.sb.toString().length() + 1])
                    continue;
                chk[nx][ny][cur.sb.toString().length() + 1] = true;
                q.add(new Point(nx, ny, new StringBuilder(cur.sb).append(ds[d])));
            }
        }
        return "impossible";
    }
}