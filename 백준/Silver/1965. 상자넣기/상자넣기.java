import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] boxes = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
            boxes[i] = s.nextInt();
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++) {
            for(int k = 0; k < i; k++) {
                if(boxes[i] > boxes[k])
                    dp[i] = Math.max(dp[i], dp[k]+1);
            }
        }

        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}