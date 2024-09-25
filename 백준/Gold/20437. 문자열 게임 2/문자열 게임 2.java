import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,List<Integer>> check = new HashMap<>();
        
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            check.clear();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            char[] W = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < W.length; i++) {
                int index = W[i]-'0';
                check.putIfAbsent(index, new ArrayList<>());
                check.get(index).add(i);
            }

            for(Map.Entry<Integer, List<Integer>> e : check.entrySet()) {
                List<Integer> list = e.getValue();
                if(list.size() >= K) {
                    for(int rear = 0, front = 0; front < list.size(); front++) {
                        if(front - rear == K-1) {
                            int len = list.get(front) - list.get(rear++) + 1;
                            min = Math.min(min, len);
                            max = Math.max(max, len);
                        }
                    }
                }
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
                System.out.println(-1);
            else
                System.out.println(min + " " + max);
        }
    }
}