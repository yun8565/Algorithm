import java.util.*;

public class Main {

    static int[] blocks;
    static int W;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int H = s.nextInt();
        W = s.nextInt();
        blocks = new int[W];

        for (int i = 0; i < W; i++)
            blocks[i] = s.nextInt();

        int rain = 0;

        for(int i = 0; i < W; i++) {
            if(i == 0 || i == W-1)
                continue;
            int leftTop = findLeftTop(i);
            int rightTop = findRightTop(i);
            int cur = blocks[i];

            if(Math.min(leftTop, rightTop) > cur)
                rain += (Math.min(leftTop, rightTop) - cur);
        }

        System.out.println(rain);
    }

    static int findLeftTop(int index) {
        int max = 0;
        for(int i = index-1; i >= 0; i--)
            max = Math.max(max, blocks[i]);
        return max;
    }

    static int findRightTop(int index) {
        int max = 0;
        for(int i = index+1; i < W; i++)
            max = Math.max(max, blocks[i]);
        return max;
    }
}