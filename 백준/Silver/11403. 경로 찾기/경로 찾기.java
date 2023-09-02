import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[][] path = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                path[i][j] = s.nextInt();

        for(int k = 0; k < N; k++)
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    if(path[i][k] == 1 && path[k][j] == 1)
                        path[i][j] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                System.out.print(path[i][j] + " ");
            System.out.println();
        }
    }
}