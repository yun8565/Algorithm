import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        long[][] dp = new long[N][N];
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = s.nextInt();

        dp[0][0] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == N-1 && j == N-1)
                    break;
                if(i + map[i][j] < N && dp[i][j] > 0)
                    dp[i+map[i][j]][j] += dp[i][j];
                if(j + map[i][j] < N && dp[i][j] > 0)
                    dp[i][j+map[i][j]] += dp[i][j];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}