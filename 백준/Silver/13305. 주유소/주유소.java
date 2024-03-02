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

        int cur = 1;
        int total = 0;
        int minCost = cost[1];

        while(cur < N) {
            int next = cur+1;
            int curDist = dist[cur];
            while(next < N && minCost < cost[next]) {
                curDist += dist[next];
                next++;
            }
            minCost = next;
            total += cost[cur] * curDist;
            cur = next;
        }
        System.out.println(total);
    }
}