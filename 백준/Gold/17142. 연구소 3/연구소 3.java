import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] spreadMap;
    static int N, M, min = Integer.MAX_VALUE;
    static List<Pair> virus = new ArrayList<>();
    static List<Pair> selected = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][N];
        spreadMap = new int[N][N];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int k = Integer.parseInt(input[j]);
                if(k == 2)
                    virus.add(new Pair(i, j));
                map[i][j] = k;
            }
        }

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                spreadMap[i][j] = map[i][j] != 1 ? 0 : -1;

        dfs(0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min-1);
    }

    static void dfs(int start) {
        if(selected.size() == M) {
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    spreadMap[i][j] = map[i][j] != 1 ? 0 : -1;
            bfs();
            check();
            return;
        }
        for(int k = start; k < virus.size(); k++) {
            selected.add(virus.get(k));
            dfs(k+1);
            selected.remove(selected.size()-1);
        }
    }

    static void check() {
        int max = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(spreadMap[i][j] == 0 && map[i][j] != 2)
                    return;
                if(map[i][j] != 2 && spreadMap[i][j] > max)
                    max = spreadMap[i][j];
            }
        }
        min = Math.min(min, max);
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>(selected);
        for(Pair p : selected)
            spreadMap[p.x][p.y] = 1;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(canGo(nx, ny)) {
                    if(spreadMap[nx][ny] == 0 && map[nx][ny] != 1) {
                        spreadMap[nx][ny] = spreadMap[cur.x][cur.y]+1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}