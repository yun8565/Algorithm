import java.util.*;

public class Main {
    static long[] dp;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        dp = new long[100];
        int T = s.nextInt();

        dp[0] = 1; dp[1] = 1; dp[2] = 1;

        for(int i = 0; i < T; i++){
            int k = s.nextInt();
            padovan(k);
        }
    }

    static void padovan(int N) {
        for(int i = 3; i < N; i++)
            dp[i] = dp[i-2] + dp[i-3];
        System.out.println(dp[N-1]);
    }
}
