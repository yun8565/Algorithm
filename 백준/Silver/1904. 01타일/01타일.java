import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] % 15746) + (dp[i-2] % 15746);
        }

        System.out.println(dp[n] % 15746);
    }
}