import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int L, C;
    static List<String> alphabet = new ArrayList<>();
    static List<String> possible = new ArrayList<>();
    static List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        L = Integer.parseInt(line.split(" ")[0]);
        C = Integer.parseInt(line.split(" ")[1]);
        visited = new boolean[C];

        alphabet.addAll(Arrays.asList(br.readLine().split(" ")));
        alphabet = alphabet.stream().sorted().collect(Collectors.toList());

        dfs(0, 0);
    }

    static void dfs(int depth, int start) {
        if(depth == L && isValid()) {
            for(String s : possible)
                System.out.print(s);
            System.out.println();
        }
        else {
            for(int i = start; i < C; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    possible.add(alphabet.get(i));
                    dfs(depth+1, i+1);
                    visited[i] = false;
                    possible.remove(possible.size() - 1);
                }
            }
        }
    }

    static boolean isValid() {
        int vowel = (int)possible.stream().filter(s -> vowels.contains(s)).count();
        int consonant = (int)possible.stream().filter(s -> !vowels.contains(s)).count();

        return vowel >= 1 && consonant >= 2;
    }
}