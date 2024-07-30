import java.util.*;

public class Main {

    static int N;
    static String[] eq = {" ","+","-"};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int t = 0; t < T; t++) {
            N = s.nextInt();
            dfs("1", 1);
            System.out.println();
        }
    }

    static void dfs(String equation, int cur) {
        if (cur == N) {
            // 계산
            int result = calculate(equation.replaceAll(" ", ""));
            if(result == 0)
                System.out.println(equation);
            return;
        }
        for(int k = 0; k < 3; k++) {
            dfs(equation+eq[k]+(cur+1), cur+1);
        }
    }

    static int calculate(String equation) {
        Queue<Integer> q = new LinkedList<>();
        String[] nums = equation.split("[+-]");

        for(String num : nums)
            q.add(Integer.parseInt(num));

        int result = q.poll();
        String eq = equation.replaceAll("[0-9]","");
        for(int i = 0; i < eq.length(); i++) {
            char op = eq.charAt(i);
            result = op == '+' ? result + q.poll() : result - q.poll();
        }

        return result;
    }
}