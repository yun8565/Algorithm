import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int K = s.nextInt();

        int[][] items = new int[N+1][2];
        int[] dp = new int[K+1];

        for(int i = 1; i <= N; i++) {
            items[i][0] = s.nextInt();
            items[i][1] = s.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            for(int j = K; j >= items[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j-items[i][0]]+items[i][1]);
            }
        }

        System.out.println(dp[K]);
    }
}