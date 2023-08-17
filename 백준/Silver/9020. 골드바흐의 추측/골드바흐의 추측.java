import java.util.*;

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        sieveOfEratosthenes(10000);

        for(int i = 0; i < T; i++) {
            int n = s.nextInt();
            goldbach(n);
        }
    }

    static void goldbach(int n) {
        int[] answer = new int[2];

        for(int i = 2; i <= n/2; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                if (answer[0] == 0 || answer[1] - answer[0] > n - 2 * i) {
                    answer[0] = i;
                    answer[1] = n - i;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    static void sieveOfEratosthenes(int n) {
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for(int i = 2; i*i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
