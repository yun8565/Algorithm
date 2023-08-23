import java.math.BigInteger;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            int M = s.nextInt();
            int N = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();

            int gcd = gcd(M, N);
            int lcm = (M*N)/gcd;

            while(x < lcm || y < lcm) {
                if(x < y)  
                    x += M;
                else if(x > y)  
                    y += N;
                else 
                    break;
            }
            System.out.println(x == y ? x : -1);
        }
    }

    static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
