import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[][] board = new int[N][3];
        int[][] minDP = new int[N][3];
        int[][] maxDP = new int[N][3];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = s.nextInt();

        minDP[0] = board[0].clone();
        maxDP[0] = board[0].clone();

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 1) {
                    minDP[i][j] = board[i][j] + Math.min(Math.min(minDP[i-1][j-1], minDP[i-1][j]), minDP[i-1][j+1]);
                    maxDP[i][j] = board[i][j] + Math.max(Math.max(maxDP[i-1][j-1], maxDP[i-1][j]), maxDP[i-1][j+1]);
                }
                else {
                    minDP[i][j] = board[i][j] + Math.min(minDP[i-1][j], j == 0 ? minDP[i-1][j+1] : minDP[i-1][j-1]);
                    maxDP[i][j] = board[i][j] + Math.max(maxDP[i-1][j], j == 0 ? maxDP[i-1][j+1] : maxDP[i-1][j-1]);
                }
            }
        }

        int max = Math.max(Math.max(maxDP[N-1][0], maxDP[N-1][1]), maxDP[N-1][2]);
        int min = Math.min(Math.min(minDP[N-1][0], minDP[N-1][1]), minDP[N-1][2]);
        System.out.println(max + " " + min);
    }
}