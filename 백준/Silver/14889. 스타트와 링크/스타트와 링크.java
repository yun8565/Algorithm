import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int point[][];
    static int visited[];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        point = new int[n][n];
        visited = new int[n];
        
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        match(0,0);
        System.out.print(answer);
    }

    //backtracking
    static void match(int depth, int k) {
        if(depth == n/2)
            answer = Math.min(answer, score());
        else {
            for(int i = k ; i < n ; i++) {
                if(visited[i] == 1) continue;
                
                visited[i] = 1;
                match(depth+1, i);
                visited[i] = 0;
            }
        }
    }
    
    static int score(){
        int start = 0, link = 0;
        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = i+1 ; j < n ; j++) {
                if(visited[i] == 1 && visited[j] == 1) {
                    start += point[i][j] + point[j][i];
                }
                if(visited[i] == 0 && visited[j] == 0) {
                    link += point[i][j] + point[j][i];
                }
            }
        }
        return Math.abs(start- link);
    }
}