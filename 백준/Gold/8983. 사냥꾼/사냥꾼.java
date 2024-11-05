import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] shootingSpots = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            shootingSpots[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(shootingSpots);

        int catchable = 0;

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int left = 0, right = shootingSpots.length-1;
            while(left <= right) {
                int mid = (left + right)/2;
                long dist = Math.abs(shootingSpots[mid]-x) + y;

                if(dist <= L) {
                    catchable++;
                    break;
                }
                if(shootingSpots[mid] <= x)
                    left = mid + 1;
                if(shootingSpots[mid] > x)
                    right = mid - 1;
            }
        }
        System.out.println(catchable);
    }
}