import java.util.*;

public class Main {
    static int n;
    static int arr[];
    static int op[];
    static int visited[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    // 같은 것이 있는 순열 -> (N-1)!/중복되는 연산자!
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        arr = new int[n];
        op = new int[n-1];
        visited = new int[n-1];

        for(int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        //1덧셈 2뺄셈 3곱셈 4나눗셈
        int index = 0;
        for(int i = 0; i < 4; i++) {
            int cnt = s.nextInt();
            for(int j = 0; j < cnt; j++)
                op[index++] = i;
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int r){
        if(r == n-1){
            int result = arr[0];
            for(int i = 0; i < n-1; i++){
                result = (visited[i] == 1) ? (result + arr[i+1]) : (visited[i] == 2) ? (result - arr[i+1]) :
                        (visited[i] == 3) ? (result * arr[i+1]) : (result / arr[i+1]);
            }
            max =  Math.max(max, result);
            min =  Math.min(min, result);
        }
        else{
            for(int i = 0; i < n-1; i++){
                if(visited[i] == 0){
                    visited[i] = op[r]+1;
                    dfs(r+1);
                    visited[i] = 0;
                }
            }
        }
    }
}