import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static boolean[] selected;
    static int[] population;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static List<Integer> groupA, groupB;
    static int N, minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        selected = new boolean[N+1];
        population = new int[N+1];
        groupA = new ArrayList<>(); groupB = new ArrayList<>();

        String[] line = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            population[i+1] = Integer.parseInt(line[i]);

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int near = Integer.parseInt(input[0]);
            for(int k = 1; k <= near; k++) {
                map.putIfAbsent(i+1, new ArrayList<>());
                map.get(i+1).add(Integer.parseInt(input[k]));
            }
        }

        dfs(1);
        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    static void dfs(int start) {
        for(int i = start; i <= N; i++) {
            selected[i] = true;
            if(isConnected())
                minDiff = Math.min(minDiff, getDiff());
            groupA.clear();
            groupB.clear();

            dfs(i+1);
            selected[i] = false;
        }
    }

    static int getDiff() {
        int sumA = groupA.stream().mapToInt(i -> population[i]).sum();
        int sumB = groupB.stream().mapToInt(i -> population[i]).sum();
        return Math.abs(sumA - sumB);
    }

    static boolean isConnected() {
        for(int i = 1; i <= N; i++) {
            if(selected[i])
                groupA.add(i);
            else groupB.add(i);
        }
        if(groupA.isEmpty() || groupB.isEmpty())
            return false;
        return bfs(groupA) & bfs(groupB);
    }

    static boolean bfs(List<Integer> group) {
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(group.get(0));
        visited[group.get(0)] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : map.getOrDefault(cur, new ArrayList<>())) {
                if(!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        for(int i : group) {
            if(!visited[i])
                return false;
        }
        return true;
    }
}