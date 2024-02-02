import java.util.*;

public class Main {

    static int N, M, D, max = 0, count = 0;
    static boolean[][] map;
    static boolean[][] simulationMap;
    static Stack<Integer> archers = new Stack<>();
    static Queue<int[]> targets = new LinkedList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        D = s.nextInt();

        map = new boolean[N][M];
        simulationMap = new boolean[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = s.nextInt() == 1;

        dfs(0);
        System.out.println(max);
    }

    static void simulate() {
        while(!gameOver()) {
            for(int a : archers)
                findTarget(a);
            while(!targets.isEmpty()) {
                int[] target = targets.poll();
                if(simulationMap[target[0]][target[1]]) {
                    simulationMap[target[0]][target[1]] = false;
                    count++;
                }
            }
            moveEnemies();
        }
        max = Math.max(max, count);
        count = 0;
    }

    static void moveEnemies() {
        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < M; j++)
                simulationMap[i][j] = i != 0 && simulationMap[i - 1][j];
        }
    }

    static void findTarget(int a) {
        int[] target = {-1,-1};
        int minDist = 20;
        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < M; j++) {
                if(simulationMap[i][j]) {
                    int dist = Math.abs(a - j) + Math.abs(N - i);
                    if (dist <= D) {
                        if(dist < minDist) {
                            minDist = dist;
                            target[0] = i;
                            target[1] = j;
                        }
                        if(dist == minDist && j < target[1]) {
                            target[0] = i;
                            target[1] = j;
                        }
                    }
                }
            }
        }
        if(target[0] >= 0)
            targets.add(target);
    }

    static boolean gameOver() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(simulationMap[i][j])
                    return false;
        return true;
    }

    static void dfs(int start) {
        if(archers.size() == 3) {
            for(int i = 0; i < N; i++)
                simulationMap[i] = map[i].clone();
            simulate();
            return;
        }
        for(int k = start; k < M; k++) {
            archers.add(k);
            dfs(k+1);
            archers.pop();
        }
    }
}
