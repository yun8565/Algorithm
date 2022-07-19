import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        BigInteger total = new BigInteger(String.valueOf(n));
        int[] applicants = new int[n];

        for(int i = 0; i < n; i++)
            applicants[i] = s.nextInt();

        int B = s.nextInt();
        int C = s.nextInt();

        for(int i : applicants){
            int tmp = i - B;
            if (tmp <= 0)
                continue;
            total = total.add(new BigInteger(String.valueOf((tmp % C == 0) ? (int)Math.ceil(tmp / C) : (int)Math.ceil(tmp / C) + 1)));
        }
        System.out.println(total);
    }
}