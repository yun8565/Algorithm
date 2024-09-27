import java.io.*;
import java.util.*;

public class Main {

    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] numbers;
    static int[] operators;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = toArray(br.readLine());
        operators = toArray(br.readLine());

        dfs();
        System.out.println(max);
        System.out.println(min);
    }

    static int[] toArray(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static void dfs() {
        if(list.size() == N-1) {
            int result = calculate();
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                list.add(i);
                operators[i]--;
                dfs();
                list.remove(list.size()-1);
                operators[i]++;
            }
        }
    }

    static int calculate() {
        int result = numbers[0];
        for(int i = 1; i < N; i++) {
            int num = numbers[i];
            int op = list.get(i-1);
            if(op == 0)
                result += num;
            if(op == 1)
                result -= num;
            if(op == 2)
                result *= num;
            if(op == 3)
                result /= num;
        }
        return result;
    }
}