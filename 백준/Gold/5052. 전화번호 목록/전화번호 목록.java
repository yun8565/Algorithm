import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<String> pq = new PriorityQueue<>();

            for(int i = 0; i < n; i++) {
                pq.add(br.readLine());
            }

            boolean flag = true;
            String first = pq.poll();

            while(!pq.isEmpty()) {
                String cur = pq.poll();
                if(first.length() <= cur.length() && cur.substring(0, first.length()).equals(first)) {
                    flag = false;
                    break;
                }
                first = cur;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}