import java.util.*;

public class Main{

    static long[][] dp;
    static int N;
    static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        dp = new long[N+1][10];
        long sum = 0;

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        stair(N);

        for(int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum % mod);
    }

    static void stair(int N) {
        for(int i = 2; i <= N; i++) {
            for(int ii = 0; ii <= 9; ii++) {
                if(ii == 0)
                    dp[i][0] = dp[i-1][1] % mod;
                else if(ii == 9)
                    dp[i][9] = dp[i-1][8] % mod;
                else
                    dp[i][ii] = (dp[i-1][ii-1] + dp[i-1][ii+1]) % mod;
            }
        }
    }
}