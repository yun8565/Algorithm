import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] str = s.nextLine().toCharArray();
        char[] explodeStr = s.nextLine().toCharArray();
        int len = explodeStr.length;

        StringBuilder sb = new StringBuilder();

        for(char c : str) {
            sb.append(c);
            if(sb.length() >= len) {
                boolean flag = true;
                for (int k = 0; k < len; k++) {
                    if (sb.charAt(sb.length() - len + k) != explodeStr[k]) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    sb.delete(sb.length() - len, sb.length());
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
