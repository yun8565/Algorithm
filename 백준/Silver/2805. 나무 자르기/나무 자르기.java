import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        int left = 0, right = -1;
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for(int h : trees)
                sum += Math.max(h-mid, 0);

            if(sum >= M)
                left = mid + 1;
            if(sum < M)
                right = mid - 1;
        }
        System.out.println(right);
    }
}