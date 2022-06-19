import java.util.*;

public class Main {
    static int M; // 가로
    static int N; // 세로

    static int[][] maze;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();

        maze = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                maze[i][j] = s.nextInt();

        dp[1][1] = maze[1][1];
        move();
        System.out.print(dp[N][M]);

    }

    public static void move(){
            for(int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++)
                    dp[i][j] = maze[i][j] + Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
    }
}