import java.util.*;

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        sieveOfEratosthenes(10000);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            int n = s.nextInt();
            goldbach(n);
        }
    }

    static void goldbach(int n) {
        for(int i = n/2; i >= 2; i--) {
            if (isPrime[i] && isPrime[n - i]) {
                System.out.println(i + " " + (n-i));
                break;
            }
        }
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