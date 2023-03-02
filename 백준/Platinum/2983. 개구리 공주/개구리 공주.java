import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static HashMap<Integer, TreeSet<Integer>> ADMap;
    static HashMap<Integer, TreeSet<Integer>> BCMap;
    static Integer curX, curY;

    public static void main(String[] args) throws Exception {
        solution();
    }
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String dir = br.readLine();
        ADMap = new HashMap<>();
        BCMap = new HashMap<>();
        Comparator<Integer> setComparator =Comparator.comparing(Integer::intValue);

        for(int i = 0; i < N; i++) {
            String[] position = br.readLine().split( " ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);

            if(i==0){
                curX = x;
                curY = y;
            }
            ADMap.putIfAbsent(y-x, new TreeSet<>(setComparator));
            BCMap.putIfAbsent(y+x, new TreeSet<>(setComparator));

            ADMap.get(y-x).add(x);
            BCMap.get(y+x).add(x);
        }

        for(char d : dir.toCharArray()) {
            TreeSet<Integer> ADSet = ADMap.get(curY-curX);
            TreeSet<Integer> BCSet = BCMap.get(curY+curX);
            Integer nextX = 0, nextY=0;

            if(d == 'A'){
                nextX = ADSet.higher(curX);
                if(nextX != null)
                    nextY = nextX+curY-curX;
                else continue;
            }
            else if(d == 'D'){
                nextX = ADSet.lower(curX);
                if(nextX != null)
                    nextY = nextX+curY-curX;
                else continue;
            }
            else if(d == 'B'){
                nextX = BCSet.higher(curX);
                if(nextX != null)
                    nextY = curX+curY-nextX;
                else continue;
            }
            else if(d == 'C'){
                nextX = BCSet.lower(curX);
                if(nextX != null)
                    nextY = curX+curY-nextX;
                else continue;
            }
            ADSet.remove(curX);
            BCSet.remove(curX);
            curX = nextX;
            curY = nextY;
        }

        System.out.println(curX+" "+curY);
    }
}