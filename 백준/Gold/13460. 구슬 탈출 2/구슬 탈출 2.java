import java.io.*;
import java.util.*;

class Balls {
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    public Balls(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

public class Main{

    static int N, M;
    static boolean[][] box;
    static boolean[][][][] visited;
    static int result = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new boolean[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = row.charAt(j);
                box[i][j] = c != '#';
                if(c == 'R') {
                    rx = i;
                    ry = j;
                }
                else if(c == 'B') {
                    bx = i;
                    by = j;
                }
                else if(c == 'O')
                    hole = new int[]{i, j};
            }
        }
        bfs(new Balls(rx, ry, bx, by,0));
        System.out.println(result);
    }

    static void bfs(Balls balls) {
        Queue<Balls> q = new LinkedList<>();
        q.offer(balls);

        visited[balls.rx][balls.ry][balls.bx][balls.by]= true;

        while (!q.isEmpty()) {
            Balls cur = q.poll();

            if(cur.count > 10) {
                result = -1;
                return;
            }

            if(isHole(cur.bx, cur.by))
                continue;

            if(isHole(cur.rx, cur.ry)) {
                result = cur.count;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int bx = cur.bx;
                int by = cur.by;

                while(box[bx+dx[i]][by+dy[i]]) {
                    bx += dx[i];
                    by += dy[i];
                    if(isHole(bx, by)) break;
                }

                int rx = cur.rx;
                int ry = cur.ry;

                while(box[rx+dx[i]][ry+dy[i]]) {
                    rx += dx[i];
                    ry += dy[i];
                    if(isHole(rx, ry)) break;
                }

                if(bx == rx && by == ry && !isHole(rx, ry)) {
                    int r_dis = Math.abs(cur.rx - rx) + Math.abs(cur.ry - ry);
                    int b_dis = Math.abs(cur.bx - bx) + Math.abs(cur.by - by);

                    if(r_dis > b_dis) {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                    else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if(!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    q.offer(new Balls(rx, ry, bx, by, cur.count + 1));
                }
            }
        }
    }

    static boolean isHole(int x, int y) {
        return x == hole[0] && y == hole[1];
    }
}