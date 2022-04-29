import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    // 서로 공격할 수 있는 위치가 아닌가? 배치할 수 있는가?
    public static boolean promising(int i){
        int k = 1;
        boolean flag = true;
        while(k < i && flag){
            if((col[i] == col[k]) || (Math.abs(col[i] - col[k]) == i - k))
                flag = false;
            k++;
        }
        return flag;
    }

    // 퀸 배치 함수
    public static void queens(int i){
        int j;
        if(promising(i)){
            if(i == n)
                count++;
            else
                for(j = 1; j <= n; j++) {
                    col[i + 1] = j;
                    queens(i+1);
                }
        }
    }

}