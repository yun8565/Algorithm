import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] kids = new int[N];

        String[] heights = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            kids[i] = Integer.parseInt(heights[i]);

        for(int i = 1; i < N; i++)
            pq.add(kids[i] - kids[i-1]);

        int min = 0;
        for(int i = 0; i < N-K; i++)
            min += pq.poll();

        System.out.println(min);
    }
}