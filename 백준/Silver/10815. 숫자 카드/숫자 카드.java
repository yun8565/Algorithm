import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(list::add);

        int M = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            boolean flag = true;
            int left=0, right=list.size()-1;
            int toFind = Integer.parseInt(input[i]);

            while(left<=right) {
                int mid = (left+right)/2;
                if(list.get(mid) == toFind) {
                    answer.append(1 + " ");
                    flag = false;
                    break;
                }
                if(list.get(mid) > toFind)
                    right = mid - 1;
                if(list.get(mid) < toFind)
                    left = mid + 1;
            }
            if(flag)
                answer.append(0 + " ");
        }
        System.out.println(answer.toString());
    }
}