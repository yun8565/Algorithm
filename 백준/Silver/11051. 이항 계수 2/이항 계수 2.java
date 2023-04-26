import java.util.*;

public class Main {

    static int N, K;
    static int[][] dp;

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        K = s.nextInt();

        dp = new int[N+1][((N+1)/2)+1];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= i/2; j++) {
                if(j == 0)
                    dp[i][j] = 1;
                else if(i % 2 == 0 && j == i/2)
                    dp[i][j] = (dp[i-1][j-1] * 2) % 10007;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }

        System.out.println(K < (N+1)/2 ? dp[N][K] : dp[N][N-K]);
    }
}