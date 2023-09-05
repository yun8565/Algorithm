import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        while(T-- > 0) {
            char[] W = s.next().toCharArray();
            int K = s.nextInt();

            HashMap<Integer,List<Integer>> check = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < W.length; i++) {
                int index = W[i]-'0';
                check.putIfAbsent(index, new ArrayList<>());
                check.get(index).add(i);
            }

            for(Map.Entry<Integer, List<Integer>> e : check.entrySet()) {
                List<Integer> list = e.getValue();
                if(list.size() >= K) {
                    int rear = 0;
                    for(int front = 0; front < list.size(); front++) {
                        if(front - rear == K-1) {
                            min = Math.min(min, list.get(front)-list.get(rear)+1);
                            max = Math.max(max, list.get(front)-list.get(rear++)+1);
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