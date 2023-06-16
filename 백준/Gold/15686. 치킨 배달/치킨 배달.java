import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited;
    static List<Pair> house = new ArrayList<>();
    static List<Pair> chicken = new ArrayList<>();
    static List<Pair> combination = new ArrayList<>();
    static int minScore = Integer.MAX_VALUE;
    
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int n = s.nextInt();
                if(n == 2)
                    chicken.add(new Pair(i, j));
                if(n == 1)
                    house.add(new Pair(i, j));
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(minScore);
    }

    static void dfs(int depth, int start) {
        if(depth == M)
            minScore = Math.min(minScore, getTotalDist());
        else {
            for(int i = start; i < chicken.size(); i++) {
                if(!visited[i]) {
                    combination.add(chicken.get(i));
                    visited[i] = true;
                    dfs(depth + 1, i + 1);
                    combination.remove(combination.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    static int getTotalDist() {
        int sum = 0;
        for(Pair h : house) {
            int minDist = Integer.MAX_VALUE;
            for(Pair chicken : combination) {
                int dist = Math.abs(h.x - chicken.x) + Math.abs(h.y - chicken.y);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }
}