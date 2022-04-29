import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[] cards;
    static int[] dp;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();

        cards = new int[N+1];
        dp = new int[N+1];

        for(int i = 1; i <= N; i++)
                cards[i] = s.nextInt();

        dp[1] = cards[1];
        findMax();
        System.out.print(dp[N]);
    }

    public static void findMax(){
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(cards[i], dp[i-j]+dp[j]));
            }
        }
    }
}