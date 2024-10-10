import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cities = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            cities[i] = Integer.parseInt(input[i]);

        Arrays.sort(cities);

        int M = Integer.parseInt(br.readLine());

        int max = M/N;
        int left = cities[0];
        int right = cities[N-1];
        int sum = Arrays.stream(cities).sum();
        
        if(sum <= M) {
            System.out.println(right);
            return;
        }
        while(left < right){
            int mid = (left + right)/2;
            sum = Arrays.stream(cities).map(i -> Math.min(i, mid)).sum();
            if(sum > M){
                right = mid;
            }
            if(sum <= M) {
                max = Math.max(max, mid);
                left = mid + 1;
            }
        }
        System.out.println(max);
    }
}