import java.util.*;

public class Main {

    static int R,C;
    static char[][] map;
    static List<Pair> fire = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minTime = Integer.MAX_VALUE;
    static boolean[][] visited;
    static boolean[][] fireVisited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        R = s.nextInt();
        C = s.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];
        fireVisited = new boolean[R][C];
        int[] start = new int[2];

        for(int i = 0; i < R; i++) {
            String line = s.next();
            for(int j = 0; j < C; j++) {
                char c = line.charAt(j);
                if(c == 'J') {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = '.';
                    continue;
                }
                if(c == 'F') {
                    fire.add(new Pair(i, j, 0, true));
                    fireVisited[i][j] = true;
                }
                map[i][j] = c;
            }
        }

        bfs(start[0], start[1]);
        System.out.println(minTime == Integer.MAX_VALUE ? "IMPOSSIBLE" : minTime);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        List<Pair> temp = new ArrayList<>();
        boolean flag = true;

        q.add(new Pair(x,y,0, false));
        q.addAll(fire);
        visited[x][y] = true;

        while(flag) {
            while (!q.isEmpty()) {
                Pair p = q.poll();
                if(!p.fire && fireVisited[p.x][p.y])
                    break;

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (escaped(nx, ny)) {
                        if(!p.fire) {
                            minTime = Math.min(minTime, p.time + 1);
                            flag = false;
                        }
                        continue;
                    }
                    if (map[nx][ny] == '.') {
                        if(p.fire && !fireVisited[nx][ny]) {
                            map[nx][ny] = 'F';
                            fireVisited[nx][ny] = true;
                            temp.add(new Pair(nx, ny, p.time + 1, p.fire));
                        }
                        if(!p.fire && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            temp.add(new Pair(nx, ny, p.time + 1, p.fire));
                        }
                    }
                }
            }
            if(temp.isEmpty() && q.isEmpty())
                break;
            q.addAll(temp);
            temp.clear();
        }
    }

    static boolean escaped(int x, int y) {
        return x < 0 || y < 0 || x >= R || y >= C;
    }

    static class Pair {
        int x,y,time;
        boolean fire;

        public Pair(int x, int y, int time, boolean fire) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.fire = fire;
        }
    }
}