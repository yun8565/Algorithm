import java.util.*;

public class Main {
    static int N;

    static int[] time;
    static int[] profit;
    static int[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();

        time = new int[N+1];
        profit = new int[N+1];
        dp = new int[N+1];

        for(int i = 1; i <= N; i++) {
            time[i] = s.nextInt();
            profit[i] = s.nextInt();
        }

        consult();
        Arrays.sort(dp);
        System.out.print(dp[N]);
    }

    public static void consult(){
        for(int i = 1; i <= N; i++) {
            if(time[i] <= N-i+1)
                for (int j = 1; j <= i; j++)
                    dp[i] = time[i-j] <= j ? Math.max(dp[i], profit[i] + dp[i-j]) : Math.max(dp[i], profit[i]);
        }
    }
}