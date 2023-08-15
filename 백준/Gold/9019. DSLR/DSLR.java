import java.util.*;

public class Main {

    static int B;
    static String answer;
    static boolean[] visited;
    static String[] op = {"D", "S", "L", "R"};

    static class Pair {
        int n;
        StringBuilder sb;

        public Pair(int n, StringBuilder sb) {
            this.n = n;
            this.sb = sb;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            visited = new boolean[10000];
            answer = null;

            int A = s.nextInt();
            B = s.nextInt();

            bfs(A);
            System.out.println(answer);
        }
    }

    static void bfs(int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, new StringBuilder()));
        visited[n] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.n == B) {
                if(answer == null || cur.sb.length() < answer.length())
                    answer = cur.sb.toString();
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int next = DSLR(cur.n, i);
                if (!visited[next]) {
                    StringBuilder sb = new StringBuilder(cur.sb).append(op[i]);
                    q.add(new Pair(next, sb));
                    visited[next] = true;
                }
            }
        }
    }

    static int DSLR(int n, int i) {
        switch(i) {
            case 0 : return (2*n) % 10000;
            case 1 : return n == 0 ? 9999 : n-1;
            case 2 : return (n%1000)*10 + (n/1000);
            case 3 : return (n%10) * 1000 + (n / 10);
            default: return 0;
        }
    }
}