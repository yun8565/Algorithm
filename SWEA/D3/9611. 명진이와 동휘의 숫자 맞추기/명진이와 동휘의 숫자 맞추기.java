import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = s.nextInt();
            int answer = 0;
            int[] numbers = new int[4];
            int[] check = new int[10];
            Arrays.fill(check, 1);
            for(int i = 0; i < N; i++) {
                for(int k = 0; k < 4; k++)
                    numbers[k] = s.nextInt();
                String st = s.next();
                for(int l = 0; l < 4; l++)
                    check[numbers[l]] = st.equals("YES") ? check[numbers[l]]*2 : 0;
            }
            
            int max = -1;
            for(int i = 0; i < 10; i++) {
                if(check[i] > max) {
                   	max = check[i];
                    answer = i;
                }
            }            
            System.out.println("#"+tc+" "+answer);
        }
    }
}
