import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static StringBuilder answer = new StringBuilder();
    static StringBuilder start = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean flag = true;

        start.append(alphabet.substring(0, k));
        answer.append(br.readLine());

        //?????줄을 기준으로..
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            if (st.charAt(0) == '?') {
                flag = false;
                continue;
            }
            if (flag) swap(0, st);
            else stack.push(st);
        }

        while(stack.size() > 0)
            swap(1, stack.pop());

        System.out.println(make_ladder());
    }

    public static String make_ladder() {
        String result = "";

        for(int i = 0; i < k - 1; i++){
            if(start.charAt(i) == answer.charAt(i))
                result += "*";
            else if(start.charAt(i) == answer.charAt(i+1) || start.charAt(i+1) == answer.charAt(i)) {
                result += "-";
                char temp = start.charAt(i);
                start.setCharAt(i, start.charAt(i+1));
                start.setCharAt(i+1, temp);
            }
            else{
                result = "";
                for(int j = 0; j < k - 1; j++)
                    result += "x";
                break;
            }

        }
        return result;
    }

    public static void swap(int dir, String pattern) {
        int index = -1;
        //밑으로. start 작업
        if (dir == 0) {
            while ((index = pattern.indexOf('-', index + 1)) != -1) {
                char temp = start.charAt(index);
                start.setCharAt(index, start.charAt(index + 1));
                start.setCharAt(index + 1, temp);
            }
        }
        //위로. answer 작업
        else {
            while ((index = pattern.indexOf('-', index + 1)) != -1) {
                char temp = answer.charAt(index);
                answer.setCharAt(index, answer.charAt(index + 1));
                answer.setCharAt(index + 1, temp);
            }
        }
    }
}
