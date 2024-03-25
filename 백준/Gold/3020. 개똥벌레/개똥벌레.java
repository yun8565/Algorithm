import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int H = s.nextInt();

        int[] up = new int[H+2];
        int[] down = new int[H+2];

        for(int i = 0; i < N; i+=2) {
             down[s.nextInt()]++;
             up[H-s.nextInt()+1]++;
        }

        for(int i = 1; i <= H; i++) {
            down[i] += down[i-1];
        }

        for(int i = H; i > 0; i--) {
            up[i] += up[i+1];
        }

        int min = N;
        int count = 0;
        for(int i = 1; i <= H; i++) {
            int toBreak = down[H]-down[i-1] + up[1]-up[i+1];
            if(min == toBreak)
                count++;
            if(min > toBreak) {
                min = toBreak;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }
}