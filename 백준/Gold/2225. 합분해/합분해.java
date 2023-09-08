import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int K = s.nextInt();

        int[][] dp = new int[K+1][N+1];

        for(int i = 1; i <= K; i++)
            for (int j = 0; j <= N; j++)
                dp[i][j] = j == 0 ? 1 : (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;

        System.out.println(dp[K][N]);
    }
}

/*
    1: 1,1,1,1
    2: 1,2,3,4
    3: 1,3,6,10
    4: 1,4,10,20
*/