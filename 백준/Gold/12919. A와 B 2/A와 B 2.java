import java.util.*;

public class Main {

    static String S;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        S =s.next();
        String T = s.next();

        System.out.println(dfs(T));
    }

    static int dfs(String T) {
        if(S.length() == T.length()) {
            if(S.equals(T))
                return 1;
            return 0;
        }

        int possible = 0;
        if(T.charAt(0) == 'B') {
            String tmp = T.substring(1, T.length());
            possible += dfs(new StringBuilder(tmp).reverse().toString());
        }
        if(T.charAt(T.length()-1) == 'A') {
            possible += dfs(T.substring(0, T.length()-1));
        }
        return possible > 0 ? 1 : 0;
    }
}