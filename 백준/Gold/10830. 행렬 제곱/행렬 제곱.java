import java.io.*;

public class Main {

    static int[][] matrix;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        long B = Long.parseLong(input[1]);

        matrix = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(str[j]) % 1000;
        }

        matrix = divide(matrix, B);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    static int[][] divide(int[][] matrix, long B) {
        if(B == 1)
            return matrix;

        int[][] result = divide(matrix, B/2);
        result = multiply(result, result);
        return B%2 == 0 ? result : multiply(result, matrix);
    }

    static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    result[i][j] = (result[i][j] + (m1[i][k] * m2[k][j])) % 1000;
        }

        return result;
    }
}