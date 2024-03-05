import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        Queue<Long> pq = new PriorityQueue<>();
        long total = 0;

        while(N-- > 0) {
            long card = s.nextLong();
            pq.add(card);
        }

        if(N == 1)
            System.out.println(0);
        else {
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                pq.add(sum);
                total += sum;
            }
        }

        System.out.println(total);
    }
}