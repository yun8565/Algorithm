import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> knowsTruth = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        for(int i = 0; i < K; i++) {
            knowsTruth.add(s.nextInt());
        }
        for(int i = 0; i < M; i++) {
            int n = s.nextInt();
            map.putIfAbsent(i, new ArrayList<>());
            for(int k = 0; k < n; k++) {
                map.get(i).add(s.nextInt());
            }
        }

        boolean[] visited = new boolean[M];
        boolean[] knows = new boolean[N+1];

        int answer = M;
        Queue<Integer> q = new LinkedList<>();
        for(int i : knowsTruth) {
            q.add(i);
            knows[i] = true;
        }

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < map.size(); i++) {
                if (!visited[i]) {
                    List<Integer> list = map.get(i);
                    if (list.contains(cur)) {
                        for (int n : list) {
                            if (n != cur && !knows[n]) {
                                knows[n] = true;
                                q.add(n);
                            }
                        }
                        visited[i] = true;
                        answer--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}