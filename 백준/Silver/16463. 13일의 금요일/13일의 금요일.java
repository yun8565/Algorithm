import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean yun = false;
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int cnt = 0;
        int day = 1;
        int n = s.nextInt();

        for(int year = 2019; year <= n; year++){
            yun = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

            for(int days : month){
                if((day+12) % 7 == 4) cnt++;
                day += (days == 28 && yun) ? 29 : days;
            }
        }
        System.out.println(cnt);
    }
}
