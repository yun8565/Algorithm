import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int k = s.nextInt();
        int n = s.nextInt();

        long[] lines = new long[k];
        long min = 1, max = 0, mid = 0;

        for(int i = 0; i < k; i++) {
            long len = s.nextLong();
            max = Math.max(max, len);
            lines[i] = len;
        }

        while(min <= max) {
            mid = (min + max) / 2;

            long pieces = 0;

            for(long line : lines)
                pieces += line / mid;

            if(pieces >= n)
                min = mid + 1;
            else
                max = mid - 1;
        }
        System.out.println(max);
    }
}