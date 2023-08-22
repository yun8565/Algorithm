import java.util.*;

public class Main {

    static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int cnt = 0;

        sieveOfEratosthenes(N);

        for(int i = 0; i < prime.size(); i++) {
            int sum = 0;
            int j = i;
            while(sum < N && j < prime.size())
                sum += prime.get(j++);
            if(sum == N) cnt++;
        }

        System.out.println(cnt);
    }

    static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for(int i = 2; i*i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        for(int i = 2; i <= n; i++)
            if(isPrime[i])
                prime.add(i);
    }
}
