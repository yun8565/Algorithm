import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();

        int[] time = new int[N+1];
        int[] profit = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++) {
            time[i] = s.nextInt();
            profit[i] = s.nextInt();
            
            if(time[i] <= N-i+1)
                for (int j = 1; j <= i; j++)
                    dp[i] = time[i-j] <= j ? Math.max(dp[i], profit[i] + dp[i-j]) : Math.max(dp[i], profit[i]);
        }
        Arrays.sort(dp);
        System.out.print(dp[N]);
    }
}