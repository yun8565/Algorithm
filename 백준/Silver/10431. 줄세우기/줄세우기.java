import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int P = s.nextInt();
        int[] line = new int[20];

        for(int i = 1; i <= P; i++) {
            int T = s.nextInt();
            int count = 0;

            for(int k = 0; k < 20; k++) {
                int height = s.nextInt();
                line[k] = height;
                for(int l = k-1; l >= 0; l--) {
                    if(line[l] > height)
                        count++;
                }
            }
            System.out.println(T + " " + count);
        }
    }
}
