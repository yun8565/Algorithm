import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[][] dp = new int[N][3];
        int[][] cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = s.nextInt();
                if (i == 0)
                    dp[i][j] = cost[i][j];
            }
        }

        for(int i = 1; i < N; i++) {
            for (int k = 0; k < 3; k++) {
                dp[i][k] = Math.min(dp[i - 1][(k + 1) % 3], dp[i - 1][(k + 2) % 3]) + cost[i][k];
            }
        }

        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}