import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] dist = new int[N];
        int[] cost = new int[N+1];

        for(int i = 1; i < N; i++)
            dist[i] = s.nextInt();

        for(int i = 1; i <= N; i++)
            cost[i] = s.nextInt();

        long total = 0;
        long minCost = cost[1];

        for(int i = 1; i < N; i++) {
            if(cost[i] < minCost)
                minCost = cost[i];
            total += minCost * dist[i];
        }
        System.out.println(total);
    }
}