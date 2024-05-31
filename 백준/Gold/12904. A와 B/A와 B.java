import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String S = s.next();
        String T = s.next();

        StringBuilder sb = new StringBuilder(T);
        while(sb.length() > S.length()) {
            if(sb.charAt(sb.length()-1) == 'A')
                sb.deleteCharAt(sb.length()-1);
            else if(sb.charAt(sb.length()-1) == 'B') {
                sb.deleteCharAt(sb.length()-1);
                sb.reverse();
            }
        }

        System.out.println(sb.toString().equals(S) ? 1 : 0);
    }
}