import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] dp = new int[N+1];
        int[] card = new int[N+1];

        for(int i = 1; i <= N; i++)
            card[i] = s.nextInt();

        for(int i = 1; i <= N; i++) {
            dp[i] = card[i];
            for(int k = 1; k < i; k++)
                dp[i] = Math.min(dp[i], dp[i-k] + card[k]);
        }

        System.out.println(dp[N]);
    }
}