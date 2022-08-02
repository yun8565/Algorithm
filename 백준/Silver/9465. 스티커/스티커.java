import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for(int i = 0; i < t; i++){
            int n = s.nextInt();
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];

            for(int j = 0; j < 2; j++){
                for(int k = 0; k < n; k++)
                    sticker[j][k] = s.nextInt();
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if(n > 1){
                dp[0][1] = sticker[1][0] + sticker[0][1];
                dp[1][1] = sticker[0][0] + sticker[1][1];
            }
            if(n>2) {
                for (int l = 2; l < n; l++) {
                    for (int k = 0; k < 2; k++) {
                        dp[k][l] = sticker[k][l] +
                                Math.max(dp[Math.abs(k - 1)][l - 1],
                                        Math.max(dp[Math.abs(k - 1)][l - 2], dp[k][l - 2]));
                    }
                }
            }
            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}
