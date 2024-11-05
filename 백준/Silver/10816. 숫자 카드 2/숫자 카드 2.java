import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .forEach(i -> map.put(i, map.getOrDefault(i, 0)+1));

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for(int i = 0; i < M; i++) {
            int toFind = Integer.parseInt(input[i]);
            answer.append(map.getOrDefault(toFind, 0) + " ");
        }
        System.out.println(answer);
    }
}