import java.io.*;
import java.util.Arrays;

public class Main {

    static boolean[] base;
    static int[] turn;
    static int[][] score;
    static boolean[] visited;
    static int N, maxRun = 0, cur = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        base = new boolean[4];
        turn = new int[10];
        score = new int[N][10];
        visited = new boolean[10];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 9; j++)
                score[i][j+1] = Integer.parseInt(input[j]);
        }

        turn[4] = 1;

        dfs(1);
        System.out.println(maxRun);
    }

    static void dfs(int depth) {
        if(depth == 10) {
            int totalRun = 0;
            for(int i = 0; i < N; i++) {
                totalRun += simulate(i);
                Arrays.fill(base, false);
            }
            maxRun = Math.max(maxRun, totalRun);
            cur = 1;
            return;
        }
        if(depth == 4) {
            dfs(depth + 1);
            return;
        }

        for(int i = 2; i <= 9; i++) {
            if(!visited[i]) {
                turn[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
                turn[depth] = 0;
            }
        }
    }

    static int simulate(int inning) {
        int outCount = 0, run = 0;

        while(outCount < 3) {
            int hit = score[inning][turn[cur]];
            if (hit == 0)
                outCount++;
            else {
                for(int k = 3; k >= 1; k--) {
                    if(base[k]) {
                        if(k+hit > 3)
                            run++;
                        else
                            base[k+hit] = true;
                        base[k] = false;
                    }
                }
                if(hit == 4)
                    run++;
                else
                    base[hit] = true;
            }
            cur = (cur % 9)+1;
        }
        return run;
    }
}