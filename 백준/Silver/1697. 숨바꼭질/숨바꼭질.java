import java.util.*;

public class Main{

    static boolean[] visited = new boolean[100001];
    static int N, K, minTime = Integer.MAX_VALUE;

    static class Pair {
        int position;
        int time;

        public Pair(int p, int t) {
            this.position = p;
            this.time = t;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        K = s.nextInt();

        bfs();

        System.out.println(minTime);
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(N, 0));
        visited[N] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.position == K) {
                minTime = Math.min(minTime, cur.time);
            }


            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int np = cur.position - 1;
                    if(canGo(np)) {
                        visited[np] = true;
                        q.add(new Pair(np, cur.time + 1));
                    }
                }
                if (i == 1) {
                    int np = cur.position + 1;
                    if(canGo(np)) {
                        visited[np] = true;
                        q.add(new Pair(np, cur.time + 1));
                    }
                }
                if (i == 2) {
                    int np = cur.position * 2;
                    if(canGo(np)) {
                        visited[np] = true;
                        q.add(new Pair(np, cur.time + 1));
                    }
                }
            }
        }
    }

    static boolean canGo(int p) {
        return 0 <= p && p <= 100000 && !visited[p];
    }
}