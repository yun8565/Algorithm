import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] board = new int[N][N];
        int[][] accSum = new int[N+1][N+1];
        
        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j<N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                accSum[i+1][j+1] = board[i][j];
                if(j != 0)
                    accSum[i+1][j+1] += accSum[i+1][j];
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++)
                if(i !=  0)
                    accSum[i+1][j+1] += accSum[i][j+1];
        }

        for(int test = 0; test < M; test++){
            input = br.readLine().split(" ");
            int startRow = Integer.parseInt(input[0]);
            int startCol = Integer.parseInt(input[1]);
            int endRow = Integer.parseInt(input[2]);
            int endCol = Integer.parseInt(input[3]);

            System.out.println(accSum[endRow][endCol] + accSum[startRow-1][startCol-1] -
                    accSum[endRow][startCol-1] - accSum[startRow-1][endCol]);
        }
    }
}