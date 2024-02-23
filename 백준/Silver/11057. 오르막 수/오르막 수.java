import java.util.*;

public class Main {
    
    static final int MOD = 10007;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[][] dp = new int[N+1][10];
        
        Arrays.fill(dp[0], 1);
        
        for(int i = 1; i < N+1; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        System.out.println(dp[N][0] % MOD);
    }
}