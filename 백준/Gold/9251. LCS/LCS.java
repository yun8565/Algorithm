import java.io.*;

public class Main {
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        DP = new int[a.length()+1][b.length()+1];

        LCS(a, b);
        System.out.println(DP[a.length()][b.length()]);
    }

    static void LCS(String a, String b){
        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++)
                DP[i][j] = (a.charAt(i-1) == b.charAt(j-1)) ? DP[i-1][j-1] + 1 : Math.max(DP[i-1][j], DP[i][j-1]);
        }
    }

}
