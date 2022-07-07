import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger result = new BigInteger("1");

        int n = s.nextInt();

        for(int i = 0; i < n; i++){
            result = result.multiply(two);
        }
        result = result.subtract(one);
        System.out.println(result);

        if(n <= 20)
            hanoi(n, 1, 3, 2);
    }

    public static void hanoi(int N, int start, int end, int via){
        if(N == 1)
            System.out.println(start + " " + end);
        else{
            hanoi(N-1, start, via, end);
            System.out.println(start + " " + end);
            hanoi(N-1, via, end, start);
        }
    }
}