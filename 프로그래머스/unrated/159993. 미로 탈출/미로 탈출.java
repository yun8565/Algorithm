import java.util.*;

class Solution {

    static class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    int N, M;
    boolean[][] visited;
    char[][] map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    Pair start, lever, exit;
    int minDistToLever = Integer.MAX_VALUE;
    int minDistToExit = Integer.MAX_VALUE;

    public int solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String s = maps[i];
            for(int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if(c == 'S')
                    start = new Pair(i, j, 0);
                if(c == 'L')
                    lever = new Pair(i, j, 0);
                if(c == 'E')
                    exit = new Pair(i, j, 0);
                map[i][j] = c;
            }
        }

        bfs(start, lever);
        visited = new boolean[N][M];
        bfs(lever, exit);

        if(minDistToLever == Integer.MAX_VALUE || minDistToExit == Integer.MAX_VALUE)
            return -1;
        else return minDistToLever + minDistToExit;
    }

    public void bfs(Pair from, Pair to) {
        Queue<Pair> q = new LinkedList<>();
        q.add(from);
        visited[from.x][from.y] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.x == to.x && cur.y == to.y) {
                if(from.x == start.x && from.y == start.y)
                    minDistToLever = Math.min(minDistToLever, cur.dist);
                else minDistToExit = Math.min(minDistToExit, cur.dist);
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(!visited[nx][ny] && map[nx][ny] != 'X') {
                        q.add(new Pair(nx, ny, cur.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}