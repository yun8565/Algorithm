import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N;
        N = s.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        System.out.print(arr[0] + " " + arr[arr.length-1]);
    }
}