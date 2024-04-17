import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.next();
        List<Integer> laser = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] stick = new int[str.length()];
        int cnt = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(')
                stack.push(i);
            if(c == ')') {
                int start = stack.pop();
                if(start == i-1)
                    laser.add(start);
                else {
                    cnt++;
                    for(int k = start; k <= i; k++)
                        stick[k]++;
                }
            }
        }

        for(int l : laser)
            cnt += stick[l];

        System.out.println(cnt);
    }
}