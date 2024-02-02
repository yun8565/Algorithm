import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int X = s.nextInt();

        int[] views = new int[N];
        int sum = 0;
        int max = 0, count = 1;

        for(int i = 0; i < N; i++) {
            views[i] = s.nextInt();
        }

        for(int i = 0; i < X; i++)
            sum += views[i];

        max = sum;

        for(int i = X; i < N; i++) {
            sum += views[i] - views[i-X];
            if(max == sum)
                count++;
            if(max < sum) {
                max = sum;
                count = 1;
            }
        }

        if(max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}