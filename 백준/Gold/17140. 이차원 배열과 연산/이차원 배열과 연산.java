import java.io.*;
import java.util.*;

public class Main {

    static int r, c, k;
    static int[][] arr;
    static int rowCnt = 3, colCnt = 3;
    static HashMap<Integer,Integer> map = new HashMap<>();
    static Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            int compareVal = o1.getValue().compareTo(o2.getValue());
            return compareVal == 0 ? o1.getKey().compareTo(o2.getKey()) : compareVal;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0])-1;
        c = Integer.parseInt(input[1])-1;
        k = Integer.parseInt(input[2]);

        int time = 0;
        arr = new int[100][100];

        for(int i = 0; i < 3; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(str[j]);
        }

        while(arr[r][c] != k) {
            if(time == 100) {
                time = -1;
                break;
            }

            if(rowCnt >= colCnt)
                R();
            else
                C();
            time++;
        }

        System.out.println(time);
    }

    static void R() {
        int max = 0;
        for(int i = 0; i < rowCnt; i++) {
            int kk = 0;

            for(int k = 0; k < colCnt; k++) {
                if(arr[i][k] != 0)
                    map.put(arr[i][k], map.getOrDefault(arr[i][k], 0)+1);
            }

            List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(comparator);

            for(Map.Entry<Integer,Integer> e : entryList) {
                if(kk == 100)
                    break;
                arr[i][kk] = e.getKey();
                arr[i][kk+1] = e.getValue();
                kk += 2;
            }
            Arrays.fill(arr[i], kk, arr[i].length, 0);
            map.clear();
            max = Math.max(max, kk);
        }
        colCnt = max;
    }

    static void C() {
        int max = 0;
        for(int j = 0; j < colCnt; j++) {
            int kk = 0;

            for(int k = 0; k < rowCnt; k++) {
                if(arr[k][j] != 0)
                    map.put(arr[k][j], map.getOrDefault(arr[k][j], 0) + 1);
            }

            List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(comparator);

            for(Map.Entry<Integer,Integer> e : entryList) {
                if(kk == 100)
                    break;
                arr[kk][j] = e.getKey();
                arr[kk+1][j] = e.getValue();
                kk += 2;
            }

            while(kk < rowCnt)
                arr[kk++][j] = 0;

            map.clear();
            max = Math.max(max, kk);
        }
        rowCnt = max;
    }
}