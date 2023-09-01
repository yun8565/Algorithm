import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int ab1 = Math.abs(o1);
            int ab2 = Math.abs(o2);

            if(ab1 < ab2)
                return -1;
            else if(ab1 > ab2)
                return 1;
            else
                return o1.compareTo(o2);
        });

        int N = s.nextInt();

        for(int i = 0; i < N; i++) {
            int n = s.nextInt();

            if(n == 0)
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            else
                pq.add(n);
        }
    }
}