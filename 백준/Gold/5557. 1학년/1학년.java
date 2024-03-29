import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        long[][] dp = new long[N-1][21];
        int[] num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = s.nextInt();
        }

        dp[0][num[0]] = 1;
        for(int i = 1; i < N-1; i++) {
            for(int k = 0; k <= 20; k++) {
                if(dp[i-1][k] > 0) {
                    if(isInRange(k-num[i]))
                        dp[i][k-num[i]] += dp[i-1][k];
                    if(isInRange(k+num[i]))
                        dp[i][k+num[i]] += dp[i-1][k];
                }
            }
        }

        System.out.println(dp[N-2][num[N-1]]);
    }

    static boolean isInRange(int i) {
        return i >= 0 && i <= 20;
    }
}