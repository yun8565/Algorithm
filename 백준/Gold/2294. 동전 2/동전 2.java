import java.util.*;

public class Main {
    static int k;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        k = s.nextInt();

        coin = new int[n];
        dp = new int[k+1];

        for(int i = 0; i < n; i++)
            coin[i] = s.nextInt();

        Arrays.fill(dp, 10001);
        dp[0] = 0;
        simulate();

        System.out.println((dp[k] >= 10001 || dp[k] < 0) ? -1 : dp[k]);
    }

    static void simulate() {
        for(int value : coin) {
            for(int i = value; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i-value]+1);
            }
        }
    }
}
