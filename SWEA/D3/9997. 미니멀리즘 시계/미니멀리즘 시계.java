import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int d = s.nextInt();
            System.out.printf("#%d %d %d\n", tc, d/30, (d%30)*2);
        }
    }
}