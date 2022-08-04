import java.util.*;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 0;

        if(N > 1) {
            dp[2] = 3;
            fill();
        }
        System.out.println(dp[N]);
    }

    static void fill() {
        for(int i = 4; i <= N; i += 2){
            for(int j = 2; j <= i; j += 2){
                //
                dp[i] += (j == 2) ? dp[i-j]* 3 : dp[i-j]*2;
            }
        }
    }
}
