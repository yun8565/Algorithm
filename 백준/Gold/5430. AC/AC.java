import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            boolean flag = true, print = true;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine().replaceAll("\\[|\\]", "");

            StringTokenizer st = new StringTokenizer(arr, ",");
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                deque.add(num);
            }

            for(char c : p.toCharArray()) {
                if(c == 'R')
                    flag = !flag;
                else {
                    if(deque.isEmpty()) {
                        System.out.println("error");
                        print = false;
                        break;
                    }
                    if(flag)
                        deque.removeFirst();
                    else
                        deque.removeLast();
                }
            }

            if(print)
                printMap(flag);
            deque.clear();
        }
    }

    static void printMap(boolean flag) {
        List<Integer> printList = new ArrayList<>();
        while(!deque.isEmpty()) {
            printList.add(flag ? deque.removeFirst() : deque.removeLast());
        }
        System.out.print("[");
        System.out.print(printList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")));
        System.out.println("]");
    }
}
