import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int count = 0;
        int N = s.nextInt();
        int M = s.nextInt();
        String S = s.next();

        StringBuilder sb = new StringBuilder("I");
        for(int i = 0; i < N; i++)
            sb.append("OI");

        for(int i = 0; i <= M-(2*N+1); i++) {
            String ss = S.substring(i, i+(2*N+1));
            if(ss.equals(sb.toString()))
                count++;
        }

        System.out.println(count);
    }
}