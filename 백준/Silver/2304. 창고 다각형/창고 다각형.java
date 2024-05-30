import java.util.*;

public class Main {

    static int[] height;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int start = 1000;
        int end = 0;
        int area = 0;
        height = new int[1001];

        for(int i = 0; i < N; i++) {
            int L = s.nextInt();
            int H = s.nextInt();
            height[L] = H;
            start = Math.min(start, L);
            end = Math.max(end, L);
        }

        compare(start, end, true);
        compare(start, end, false);

        for(int i = start; i <= end; i++)
            area += height[i];

        System.out.println(area);
    }

    static void compare(int start, int end, boolean left) {
        Stack<Integer> stack = new Stack<>();
        int maxH = height[left ? start : end];

        for(int i = left ? start+1 : end-1; left ? i <= end : i >= start; i += left ? 1 : -1) {
            if(height[i] < maxH)
                stack.push(i);
            else {
                while(!stack.isEmpty())
                    height[stack.pop()] = maxH;
                maxH = height[i];
            }
        }
    }
}