import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
            wines[i] = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(wines[0]);
            return;
        }
        
        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max((i > 2 ? dp[i-3] : 0)+wines[i]+wines[i-1], dp[i-2]+wines[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        System.out.println(dp[n-1]);
    }
}