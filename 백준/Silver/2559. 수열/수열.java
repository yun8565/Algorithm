import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int sum = 0;
        int[] temps = new int[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(input[i]);
            if(i < M)
                sum += temps[i];
        }

        int max = sum;
        for(int k = M; k < N; k++) {
            sum -= temps[k-M];
            sum += temps[k];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}