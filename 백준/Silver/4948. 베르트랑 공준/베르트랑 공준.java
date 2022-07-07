import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        while(true){
            int n = s.nextInt();
            if(n == 0) break;
            else{
                System.out.println(bertrand(n));
            }
        }
    }

    public static int bertrand(int n){
        int answer = 0;
        for(int i = n + 1; i <= 2*n; i++){
            for(int k = 2; k*k <= i; k++){
                if(i % k == 0){
                    answer++;
                    break;
                }
            }
        }
        return n - answer;
    }
}