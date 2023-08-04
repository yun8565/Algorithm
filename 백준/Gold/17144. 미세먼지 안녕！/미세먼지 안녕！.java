import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] spreadMap;
    static int[][] movedMap;
    static List<Integer> cleaner = new ArrayList<>();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        int T = s.nextInt();

        map = new int[N][M];
        spreadMap = new int[N][M];
        movedMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = s.nextInt();
                if(map[i][j] == -1)
                    cleaner.add(i);
            }
        }

        while(T-- > 0) {
            for(int i = 0; i < N; i++) {
                Arrays.fill(spreadMap[i], 0);
            }
            spreadDust();
            for(int i = 0; i < N; i++)
                movedMap[i] = map[i].clone();
            airCleaner();
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0)
                    sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void spreadDust() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int dust = map[i][j];
                if(dust > 0) {
                    for(int k = 0; k < 4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(canGo(nx, ny)) {
                            spreadMap[nx][ny] += dust/5;
                            map[i][j] -= dust/5;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] += spreadMap[i][j];
    }

    static boolean canGo(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M
                && map[nx][ny] != -1;
    }

    static void airCleaner() {
        int x1 = cleaner.get(0);
        int x2 = cleaner.get(1);
        int y1 = 1, y2 = 1;
        
        for(int i = 0; i < 4; i++) {
            while(canGo(x1+dx[i], y1+dy[i])) {
                movedMap[x1+dx[i]][y1+dy[i]] = map[x1][y1];
                x1 += dx[i];
                y1 += dy[i];
            }
            if(i % 2 == 0) {
                while(canGo(x2+dx[i], y2+dy[i])) {
                    movedMap[x2+dx[i]][y2+dy[i]] = map[x2][y2];
                    x2 += dx[i];
                    y2 += dy[i];
                }
            }
            else {
                while(canGo(x2+dx[(i+2)%4], y2+dy[i])) {
                    movedMap[x2+dx[(i+2)%4]][y2+dy[i]] = map[x2][y2];
                    x2 += dx[(i+2)%4];
                    y2 += dy[i];
                }
            }
        }
        movedMap[cleaner.get(0)][1] = 0;
        movedMap[cleaner.get(1)][1] = 0;

        for(int i = 0; i < N; i++)
            map[i] = movedMap[i].clone();
    }
}