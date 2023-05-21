import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int max = -1;
            int N = s.nextInt();
            int M = s.nextInt();

            int[] snacks = new int[N];

            for(int i = 0; i < N; i++)
                snacks[i] = s.nextInt();

            int first = 0;
            int second = 0;

            for(int i = 0; i < N-1; i++) {
                first = snacks[i];
                for(int j = i+1; j < N; j++) {
                    second = snacks[j];
                    if(first + second <= M)
                        max = Math.max(max, first+second);
                }
            }

            System.out.printf("#%d %d\n", tc, max);
        }
    }
}
