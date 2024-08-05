import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        dfs();
        System.out.print(sb.toString());
    }

    static void dfs() {
        if(list.size() == M) {
            for(int i : list)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= N ; i++) {
            list.add(i);
            dfs();
            list.remove(list.size()-1);
        }
    }
}