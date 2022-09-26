import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), Q = s.nextInt();

        List<int[]>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        //USADO 입력
        for (int i = 1; i < N; i++) {
            int p = s.nextInt(), q = s.nextInt(), r = s.nextInt();
            adj[p].add(new int[]{q, r});
            adj[q].add(new int[]{p, r});
        }
        
        //bfs
        for (int i = 0; i < Q; i++) {
            boolean[] visit = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            int k = s.nextInt(), v = s.nextInt();
            int cnt = 0;
            
            visit[v] = true;
            queue.add(v);
            
            while (!queue.isEmpty()) {
                int cv = queue.poll();

                for (int[] a : adj[cv]) {
                    if (!visit[a[0]] && a[1] >= k) {
                        queue.add(a[0]);
                        visit[a[0]] = true;
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        
    }
}