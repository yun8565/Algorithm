import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int[] minCount, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> pattern = List.of('A','C','G','T');
        minCount = new int[4];
        int answer = 0;

        String[] input = br.readLine().split(" ");
        int P = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        String password = br.readLine();

        input = br.readLine().split(" ");
        for(int i = 0; i < 4; i++)
            minCount[i] = Integer.parseInt(input[i]);

        count = new int[4];
        for(char c : password.substring(0, S).toCharArray()) {
            if(pattern.contains(c))
                count[pattern.indexOf(c)]++;
        }
        if(IntStream.range(0,4).allMatch(i -> count[i] >= minCount[i]))
            answer++;

        for(int k = S; k < P; k++) {
            if(pattern.contains(password.charAt(k-S)))
                count[pattern.indexOf(password.charAt(k-S))]--;
            if(pattern.contains(password.charAt(k)))
                count[pattern.indexOf(password.charAt(k))]++;
            if(IntStream.range(0,4).allMatch(i -> count[i] >= minCount[i]))
                answer++;
        }

        System.out.println(answer);
    }
}