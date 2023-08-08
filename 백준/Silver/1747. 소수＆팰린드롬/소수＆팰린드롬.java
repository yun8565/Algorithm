import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        for(int i = N; i <= 2000000; i++) {
            if(isPrime(i) && isPalindrome(i)) {
                System.out.print(i);
                break;
            }
        }
    }

    static boolean isPrime(int num) {
        if(num < 2)
            return false;
        for(int i = 2; i*i <= num; i++)
            if(num % i == 0)
                return false;
        return true;
    }

    static boolean isPalindrome(int num) {
        String s = Integer.toString(num);
        String left = s.substring(0, s.length()/2);
        String right = s.substring(s.length() % 2 == 0 ? s.length()/2 : s.length()/2+1);
        
        String reverse = new StringBuilder(right).reverse().toString();
        return left.equals(reverse);
    }
}