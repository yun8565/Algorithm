import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static int N,M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        num = new int[N];

        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(numbers[i]);
        Arrays.sort(num);

        dfs(0);
        System.out.print(sb.toString());
    }

    static void dfs(int start) {
        if(list.size() == M) {
            for(int i : list)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = start ; i < N ; i++) {
            list.add(num[i]);
            dfs(i);
            list.remove(list.size()-1);
        }
    }
}