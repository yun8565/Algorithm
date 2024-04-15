import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int index = 0;
        int num = 666;

        while(index < N-1) {
            num++;
            if(String.valueOf(num).contains("666"))
                index++;
        }

        System.out.println(num);
    }
}