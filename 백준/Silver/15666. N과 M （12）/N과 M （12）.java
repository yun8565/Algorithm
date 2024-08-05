import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static int N,M;
    static int[] num;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        num = new int[N];

        num = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        dfs(0);
        set.forEach(System.out::println);
    }

    static void dfs(int start) {
        if(list.size() == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : list)
                sb.append(i).append(" ");
            set.add(sb.toString());
            return;
        }
        for(int i = start ; i < N ; i++) {
            list.add(num[i]);
            dfs(i);
            list.remove(list.size()-1);
        }
    }
}