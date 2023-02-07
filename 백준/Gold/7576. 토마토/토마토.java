import java.io.*;
import java.util.*;

class tomato {
    int x; // 세로
    int y; // 가로

    tomato(int x, int y) {
        this.x = x; // 세로
        this.y = y; // 가로
    }
}

public class Main {
    static int M; // 가로
    static int N; // 세로

    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우위아래
    static int[] dy = { 0, 0, -1, 1 }; // 상하좌우위아래

    static int[][] box;
    static Queue<tomato> que;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로

        box = new int[N][M]; // 토마토판
        que = new LinkedList<tomato>();

        // 토마토판 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1)
                    que.add(new tomato(i, j));
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!que.isEmpty()) {
            tomato t = que.remove();

            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (box[nx][ny] == 0) {
                        que.add(new tomato(nx, ny));
                        box[nx][ny] = box[x][y] + 1; //날짜 업데이트
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return -1;
                result = Math.max(result, box[i][j]);
            }
        }
        if (result == 1)
            return 0;
        else
            return result-1;
    }
}