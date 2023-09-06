import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] arr;
    static int[][] original;
    static int[][] rotateArr;
    static int[][] ops;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N+1][M+1];
        original = new int[N+1][M+1];
        rotateArr = new int[N+1][M+1];
        ops = new int[K][];
        visited = new boolean[K];

        for(int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++) {
                int n = sc.nextInt();
                arr[i][j] = n;
                original[i][j] = n;
            }

        for(int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();

            ops[i] = new int[]{r,c,s};
        }

        int[] selected = new int[K];
        dfs(0, selected);

        System.out.println(min);
    }

    static void dfs(int depth, int[] selected) {
        if(depth == K) {
            for(int k = 1; k <= N; k++)
                arr[k] = original[k].clone();

            for(int i : selected) {
                int r = ops[i][0];
                int c = ops[i][1];
                int s = ops[i][2];

                for(int k = 1; k <= N; k++)
                    rotateArr[k] = arr[k].clone();

                while(s > 0)
                    rotate(r, c, s--);

                for(int k = 1; k <= N; k++)
                    arr[k] = rotateArr[k].clone();
            }
            min = Math.min(min, getScore());
        }
        else {
            for (int i = 0; i < K; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    selected[depth] = i;
                    dfs(depth + 1, selected);
                    visited[i] = false;
                }
            }
        }
    }

    static void rotate(int r, int c, int s) {
        int[] leftTop = {r-s, c-s};
        int[] rightBottom = {r+s, c+s};

        //왼쪽 상단에서 오른쪽으로
        for(int i = leftTop[1]+1; i <= rightBottom[1]; i++)
            rotateArr[leftTop[0]][i] = arr[leftTop[0]][i-1];
        
        //오른쪽 상단에서 아래로
        for(int j = leftTop[0]+1; j <= rightBottom[0]; j++)
            rotateArr[j][rightBottom[1]] = arr[j-1][rightBottom[1]];
        
        //오른쪽 하단에서 왼쪽으로
        for(int i = rightBottom[1]-1; i >= leftTop[1]; i--)
            rotateArr[rightBottom[0]][i] = arr[rightBottom[0]][i+1];
            
        //왼쪽 하단에서 위로
        for(int j = rightBottom[0]-1; j >= leftTop[0]; j--)
            rotateArr[j][leftTop[1]] = arr[j+1][leftTop[1]];
    }
    
    static int getScore() {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= M; j++)
                sum += arr[i][j];
            min = Math.min(min, sum);
        }
        return min;
    }
}