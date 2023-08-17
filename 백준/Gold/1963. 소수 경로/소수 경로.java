import java.util.*;

public class Main {

    static final int MAX = 10000;
    static boolean[] isPrime;
    static boolean[] visited;

    static class Pair {
        int cnt;
        StringBuilder sb;

        public Pair(int cnt, StringBuilder sb) {
            this.cnt = cnt;
            this.sb = sb;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        sieveOfEratosthenes(MAX);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            visited = new boolean[MAX];

            int n = s.nextInt();
            int goal = s.nextInt();
            optimalPassword(n, goal);
        }
    }

    static void optimalPassword(int n, int goal) {
        int min = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, new StringBuilder(String.valueOf(n))));
        visited[n] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(Integer.parseInt(cur.sb.toString()) == goal)
                min = Math.min(min, cur.cnt);

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j <= 9; j++) {
                    if(i == 0 && j == 0 || cur.sb.charAt(i) == (char)(j+'0'))
                        continue;

                    String s = cur.sb.toString();
                    int next = Integer.parseInt(s.substring(0, i) + j + s.substring(i+1));
                    if(!visited[next] && isPrime[next]) {
                        q.add(new Pair(cur.cnt+1, new StringBuilder(String.valueOf(next))));
                        visited[next] = true;
                    }
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? "Impossible" : min);
    }

    static void sieveOfEratosthenes(int n) {
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for(int i = 2; i*i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
    }
}