import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while(k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(op.equals("I"))
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

                else if(treeMap.size() == 0)
                    continue;

                else {
                    int key = num == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    int cnt = treeMap.get(key);
                    if(cnt == 1)
                        treeMap.remove(key);
                    else
                        treeMap.put(key, cnt-1);
                }
            }
            System.out.println(treeMap.size() == 0 ? "EMPTY"
                    : treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }
}