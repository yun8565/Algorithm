import java.util.*;

public class Main {

    static int[] col;
    static int n, count = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        col = new int[n+1];

        queens(0);
        System.out.print(count);
    }

    static void queens(int i) {
        if(promising(i)) {
            if(i == n)
                count++;
            else {
                for (int j = 1; j <= n; j++) {
                    col[i + 1] = j;
                    queens(i + 1);
                }
            }
        }
    }

    static boolean promising(int i) {
        for(int k = 1; k < i; k++) {
            if((col[i] == col[k]) || (Math.abs(col[i] - col[k]) == i - k))
                return false;
        }
        return true;
    }
}