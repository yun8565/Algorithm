import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] trees = new int[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            trees[i] = Integer.parseInt(input[i]);
        Arrays.sort(trees);

        int left = 0, right = trees[trees.length - 1];
        int minHeight = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for(int h : trees)
                sum += Math.max(h-mid, 0);

            if(sum >= M) {
                minHeight = mid;
                left = mid + 1;
            }
            if(sum < M)
                right = mid - 1;
        }
        System.out.println(minHeight);
    }
}