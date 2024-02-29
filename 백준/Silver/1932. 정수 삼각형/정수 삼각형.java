import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] triangle = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int k = 1; k <= i; k++) {
                triangle[i][k] = s.nextInt();
            }
        }

        for(int i = 2; i <= n; i++) {
            for(int k = 1; k <= i; k++) {
                triangle[i][k] += k == 1 ? triangle[i-1][k] : k == i ? triangle[i-1][k-1] :
                        Math.max(triangle[i-1][k-1], triangle[i-1][k]);
            }
        }

        System.out.println(Arrays.stream(triangle[n]).max().orElse(0));
    }
}