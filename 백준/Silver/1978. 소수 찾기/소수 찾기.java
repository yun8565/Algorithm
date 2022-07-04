import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int total = 0;
        for(int i = 0; i < N; i++){
            if(isPrime(s.nextInt()))
                total++;
        }
        System.out.print(total);
    }

    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}