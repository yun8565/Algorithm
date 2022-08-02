import java.util.*;

public class Main {

    static int[] stair;
    static int[] dp;
    static int n;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        stair = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i++) {
            stair[i] = s.nextInt();
        }
        
        dp[0] = stair[0];
        if(n > 1)
            dp[1] = stair[0] + stair[1];
        if(n > 2) {
            dp[2] = Math.max(stair[0]+stair[2], stair[1]+stair[2]);
            go_upstairs();
        }
        System.out.println(dp[n-1]);
    }

    static void go_upstairs(){
        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]);
        }
    }
}


