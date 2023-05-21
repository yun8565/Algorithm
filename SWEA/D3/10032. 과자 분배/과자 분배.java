import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = s.nextInt();
            int K = s.nextInt();

            System.out.printf("#%d %d\n", tc, N % K > 0 ? 1 : 0);
        }
    }
}
