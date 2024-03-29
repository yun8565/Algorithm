import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        arr = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++)
            arr[i] = s.nextInt();

        for(int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            if(hasCycle(i,i)) {
                for(int k = 1; k <= N; k++)
                    if(visited[k] && !pq.contains(k))
                        pq.add(k);
            }
        }
        System.out.println(pq.size());
        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }

    static boolean hasCycle(int node, int start) {
        if(node == start && visited[node]) {
            return true;
        }
        if(!visited[node]) {
            visited[node] = true;
            return hasCycle(arr[node], start);
        }
        else return false;
    }
}