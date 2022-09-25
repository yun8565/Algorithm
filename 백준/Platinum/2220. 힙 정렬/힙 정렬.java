import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 1; j/=2)
                arr[j] = arr[j/2];
            //루트 노드 배치
            arr[1] = i+1;
        }

        arr[n] = 1;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i+1] + " ");
    }
}