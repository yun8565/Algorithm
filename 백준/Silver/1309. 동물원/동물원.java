import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2; i <= n; i++) {
            dp[i] = ((dp[i-1] * 2) % 9901) + (dp[i-2] % 9901);
        }

        System.out.println(dp[n] % 9901);
    }
}