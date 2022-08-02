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

        dp[0] = 1;
        simulate();

        System.out.println(dp[k]);
    }

    static void simulate() {
        for(int value : coin) {
            for(int i = value; i <= k; i++) {
                    dp[i] += dp[i-value];
            }
        }
    }
}
