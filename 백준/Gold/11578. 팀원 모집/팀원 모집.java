import java.util.*;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] solved;
    static HashMap<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int M = s.nextInt();
        visited = new boolean[M];
        solved = new int[N];

        for(int i = 0; i < M; i++) {
            int n = s.nextInt();
            int[] problems = new int[n];
            for(int k = 0; k < n; k++) {
                problems[k] = s.nextInt();
            }
            map.put(i, problems);
        }

        dfs(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int depth, int start) {
        if(Arrays.stream(solved).allMatch(p -> p >= 1)) {
            min = Math.min(min, depth);
            return;
        }
        for(int i = start; i < map.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                for(int p : map.get(i))
                    solved[p-1]++;
                dfs(depth+1, i+1);
                visited[i] = false;
                for(int p : map.get(i))
                    solved[p-1]--;
            }
        }
    }
}