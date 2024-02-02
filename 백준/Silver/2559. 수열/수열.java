import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int K = s.nextInt();

        int[] temperature = new int[N];
        int sum = 0;
        int max = 0, count = 1;

        for(int i = 0; i < N; i++) {
            temperature[i] = s.nextInt();
        }

        for(int i = 0; i < K; i++)
            sum += temperature[i];

        max = sum;

        for(int i = K; i < N; i++) {
            sum += temperature[i] - temperature[i-K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}