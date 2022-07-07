import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println((int)Math.pow(2,n)-1);
        hanoi(n, 1, 3,2);
        System.out.print(sb);
    }

    public static void hanoi(int N, int start, int end, int via){
        if(N == 1)
            sb.append(start + " " + end + "\n");
        else{
            hanoi(N-1, start, via, end);
            sb.append(start + " " + end + "\n");
            hanoi(N-1, via, end, start);
        }
    }
}