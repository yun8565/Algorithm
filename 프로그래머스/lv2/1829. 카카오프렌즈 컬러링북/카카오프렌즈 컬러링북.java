import java.util.*;

class Solution {

        static class Pair {
            int x;
            int y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int[] solution(int m, int n, int[][] picture) {
            int count = 0;
            int maxArea = 0;
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            Queue<Pair> q = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && picture[i][j] != 0) {
                        q.add(new Pair(i, j));
                        visited[i][j] = true;
                        int areaCount = 1;

                        while(!q.isEmpty()) {
                            Pair cur = q.poll();
                            for(int k = 0; k < 4; k++) {
                                int nx = cur.x + dx[k];
                                int ny = cur.y + dy[k];
                                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if(!visited[nx][ny] && picture[cur.x][cur.y] == picture[nx][ny]) {
                                        q.add(new Pair(nx, ny));
                                        areaCount++;
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                        count++;
                        maxArea = Math.max(maxArea, areaCount);
                    }
                }
            }

            return new int[]{count, maxArea};
        }
}