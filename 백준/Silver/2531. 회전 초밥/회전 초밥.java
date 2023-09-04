import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int d = s.nextInt();
        int k = s.nextInt();
        int c = s.nextInt();

        int[] sushi = new int[N];
        int[] visited = new int[d+1];

        int cnt = 1;
        int max = 0;

        for(int i = 0; i < N; i++) {
            sushi[i] = s.nextInt();
        }

        visited[c]++;
        
        for(int i = 0; i < N+k-1; i++) {
            visited[sushi[i%N]]++;
            cnt += visited[sushi[i%N]] == 1 ? 1 : 0;
            if(i == k-1) {
                max = cnt;
            }
            if(i >= k) {
                if(visited[sushi[i-k]] == 1)
                    cnt--;
                visited[sushi[i-k]]--;
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}