import java.util.*;

public class Main {
    static int[] D0;
    static int[] D1;
    static int N;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        D0 = new int[41];
        D1 = new int[41];

        D0[0] = 1; D0[1] = 0;
        D1[0] = 0; D1[1] = 1;

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            N = s.nextInt();
            if(N != 0 && N != 1)
                fibonacci(0);
            System.out.println(D0[N]+" "+D1[N]);
        }
    }

    static void fibonacci(int n) {
        if(n == N+1) return;
        if (D0[n] == 0 && D1[n] == 0) {
            D0[n] = D0[n - 1] + D0[n - 2];
            D1[n] = D1[n - 1] + D1[n - 2];
        }
        fibonacci(n+1);
    }
}
