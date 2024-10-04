import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Boolean> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 0; i < N; i++)
            map.putIfAbsent(br.readLine(), true);

        int count = map.size();
        for(int i = 0; i < M; i++) {
            for(String keyword : br.readLine().split(",")) {
                if(map.getOrDefault(keyword, false)) {
                    map.put(keyword, false);
                    count--;
                }
            }
            sb.append(count+"\n");
        }
        System.out.print(sb);
    }
}