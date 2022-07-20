import java.io.*;
import java.util.*;

public class Main {
    static String[] circle_states;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        circle_states = new String[4];
        visited = new int[4];

        for(int i = 0; i < 4; i++){
            circle_states[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            rotate(a-1,b);
            Arrays.fill(visited, 0);
        }

        for(int i = 0; i < 4; i++){
            score += (circle_states[i].charAt(0) == '1') ? Math.pow(2,i) : 0;
        }
        System.out.println(score);
    }

    public static void rotate(int num, int dir){
        visited[num] = 1;
        shift(num, dir);
        //오른쪽 톱니바퀴 확인
        if(num < 3) {
            if (circle_states[num].charAt(2+dir) != circle_states[num + 1].charAt(6) && (visited[num+1] == 0))
                rotate(num + 1, -dir);
        }
        //왼쪽 톱니바퀴 확인
        if(num > 0) {
            if (circle_states[num].charAt(6+dir) != circle_states[num - 1].charAt(2) && (visited[num-1] == 0))
                rotate(num - 1, -dir);
        }
    }

    public static void shift(int num, int dir){
        if(dir == 1)
            circle_states[num] = circle_states[num].charAt(7)+circle_states[num].substring(0, 7);
        else
            circle_states[num] = circle_states[num].substring(1, 8)+circle_states[num].charAt(0);
    }
}