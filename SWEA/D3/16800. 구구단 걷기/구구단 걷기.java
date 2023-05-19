import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T;
        T = s.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            long N = s.nextLong();
            long minMove = Long.MAX_VALUE;
            
            for(long i = 1; i <= Math.sqrt(N); i++)
                if(N % i == 0)
                    minMove = Math.min(minMove, i + N/i - 2);

           System.out.println("#"+test_case+" "+minMove);
        }
    }
}
