import java.util.*;

public class Main{

    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static List<Tuple> tomato = new ArrayList<>();

    static class Tuple {
        int x;
        int y;
        int z;

        public Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        M = s.nextInt();
        N = s.nextInt();
        H = s.nextInt();
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    int n = s.nextInt();
                    if(n == 1)
                        tomato.add(new Tuple(j, k, i));
                    box[i][j][k] = n;
                }
            }
        }

        try {
            bfs();
        }
        catch(IndexOutOfBoundsException e){
            doNothing();
        }

        int time = 0;
        boolean flag = false;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0)
                        flag = true;
                    time = Math.max(time, box[i][j][k]);
                }
            }
        }

        System.out.println(flag ? -1 : time-1);
    }

    static void bfs() {
        Queue<Tuple> q = new LinkedList<>(tomato);
        visited[tomato.get(0).z][tomato.get(0).x][tomato.get(0).y] = true;

        while(!q.isEmpty()) {
            Tuple cur = q.poll();
            for(int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny, nz)) {
                    if(!visited[nz][nx][ny] && box[nz][nx][ny] == 0) {
                        visited[nz][nx][ny] = true;
                        box[nz][nx][ny] = box[cur.z][cur.x][cur.y] + 1;
                        q.add(new Tuple(nx, ny, nz));
                    }
                }
            }
        }
    }

    static boolean canGo(int x, int y, int z) {
        return (0 <= x && x < N) && (0 <= y && y < M) && (0 <= z && z < H);
    }
    
    static void doNothing(){}
}