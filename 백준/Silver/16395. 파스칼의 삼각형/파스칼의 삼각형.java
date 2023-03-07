import java.util.*;

public class Main{

    static int n, k;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        k = s.nextInt();

        dp = new int[n+1][n+1];
        dp[1][1] = 1;

        if(n >= 2)
            pascal();

        System.out.println(dp[n][(k > (n+1)/2) ? n-k+1 : k]);
    }

    static void pascal() {
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= (i+1)/2; j++) {
                if(i % 2 != 0 && j == (i+1)/2)
                    dp[i][j] = dp[i-1][j-1] * 2;
                else
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
}