import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> wordCountMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() >= M)
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
        }

        List<String> words = new ArrayList<>(wordCountMap.keySet());
        words.sort((o1, o2) -> {
            if (wordCountMap.get(o1) != wordCountMap.get(o2))
                return Integer.compare(wordCountMap.get(o2), wordCountMap.get(o1));
            if (o1.length() != o2.length())
                return Integer.compare(o2.length(), o1.length());
            return o1.compareTo(o2);
        });

        for(String word : words)
            sb.append(word+"\n");
        System.out.println(sb);
    }
}