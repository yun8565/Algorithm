import java.util.stream.Collectors;
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

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int sum = 0;
    static int n, m;

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        List<Integer> answer = new ArrayList<>();
        visited = new boolean[n][m];
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = maps[i];
            for(int j = 0; j < m; j++) {
                char c = s.charAt(j);
                map[i][j] = c == 'X' ? 0 : Character.getNumericValue(c);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    bfs(new Pair(i, j));

                    if(sum > 0) {
                        answer.add(sum);
                        sum = 0;
                    }
                }
            }
        }

        answer = answer.stream().sorted().collect(Collectors.toList());

        if(answer.isEmpty())
            return new int[]{-1};
        else {
            int[] arr = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++)
                arr[i] = answer.get(i);

            return arr;
        }
    }

    public void bfs(Pair p) {
        Queue<Pair> q = new LinkedList<>();
        visited[p.x][p.y] = true;
        sum += map[p.x][p.y];
        q.add(p);

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && map[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                        sum += map[nx][ny];
                    }
                }
            }
        }
    }

    public boolean canGo(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}