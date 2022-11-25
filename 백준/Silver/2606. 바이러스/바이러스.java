import java.util.*;

public class Main {
    static int comNum;
    static boolean[] visited;
    static int[][] network;
    static int count = 0;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        comNum = s.nextInt();
        int pairs = s.nextInt();

        network = new int[comNum+1][comNum+1];
        visited = new boolean[comNum+1];

        for(int i = 0; i < pairs; i++) {
            int first = s.nextInt();
            int second = s.nextInt();

            network[first][second] = 1;
            network[second][first] = 1;
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int startCom) {
        visited[startCom] = true;
        for(int i = 1; i <= comNum; i++) {
            if(network[startCom][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
