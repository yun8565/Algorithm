import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int K = s.nextInt();
        int sum = 0;

        int[] sensors = new int[N];
        int[] diff = new int[N-1];

        for(int i = 0; i < N; i++)
            sensors[i] = s.nextInt();
        Arrays.sort(sensors);

        for(int i = 0; i < N-1; i++)
            diff[i] = sensors[i+1] - sensors[i];
        Arrays.sort(diff);

        for(int i = 0; i < N-K; i++)
            sum += diff[i];
        System.out.println(sum);
    }
}