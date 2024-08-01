import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] heights = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(heights[i-1]);

            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(new Tower(i,height));
                    break;
                } else if (height < stack.peek().height) {
                    sb.append((stack.peek().num)).append(" ");
                    stack.push(new Tower(i, height));
                    break;
                } else stack.pop();
            }
        }

        System.out.println(sb.toString());
    }

    static class Tower {
        int num, height;
        public Tower(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}