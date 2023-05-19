import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int cnt = 0;
            for(int i = -N; i <= N; i++) {
                for(int j = -N; j <= N; j++) {
                    if(Math.sqrt(i*i + j*j) <= N)
                        cnt++;
                }
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}