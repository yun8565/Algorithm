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

        dfs(1);
        System.out.print(sb.toString());
    }

    static void dfs(int start) {
        if(list.size() == M) {
            for(int i : list)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = start ; i <= N ; i++) {
            list.add(i);
            dfs(i);
            list.remove(list.size()-1);
        }
    }
}