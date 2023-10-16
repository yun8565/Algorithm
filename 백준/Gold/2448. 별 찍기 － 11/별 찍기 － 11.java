import java.io.*;

public class Main {

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new boolean[N][N*2-1];

        makeTriangle(0, N-1, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N*2-1; j++)
                sb.append(map[i][j] ? "*" : " ");
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void makeTriangle(int level, int center, int n) {
        if(n == 3) {
            map[level][center] = map[level+2][center] = true;
            map[level+1][center-1] = map[level+1][center+1] = true;
            map[level+2][center-1] = map[level+2][center+1] = true;
            map[level+2][center-2] = map[level+2][center+2] = true;

            return;
        }
        makeTriangle(level, center, n/2);
        makeTriangle(level+n/2, center-n/2, n/2);
        makeTriangle(level+n/2, center+n/2, n/2);
    }
}