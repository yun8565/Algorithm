import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
        }
        list.sort(Integer::compareTo);

        int rear = 0; int front = 1;
        int answer = Integer.MAX_VALUE;

        while(rear <= front && front < N) {
            int next = list.get(front);
            int diff = next - list.get(rear);
            if(diff >= M) { // 1 5 8
                rear++;
                if(diff < answer)
                    answer = diff;
            }
            else front++;
        }
        int last = list.get(list.size()-1);
        while(rear < list.size()-1) {
            int diff = last - list.get(rear++);
            if(diff >= M && diff < answer)
                answer = diff;
        }

        System.out.println(answer == Integer.MAX_VALUE ? M : answer);
    }
}