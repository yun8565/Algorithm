import java.io.*;

public class Main {
    static boolean[] visited = new boolean [1<<21];
    static int n,m;
    static int[] arr;
    static int ans =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        arr = new int[n+1];

        for(int i=0; i<m; i++) {
            String[] tt = br.readLine().split(" ");
            int order = Integer.parseInt(tt[0]);
            int train = Integer.parseInt(tt[1]);

            if(order == 1) {
                int seat = Integer.parseInt(tt[2]);
                arr[train] = (arr[train] | (1<<seat));
            }
            if(order == 2) {
                int seat = Integer.parseInt(tt[2]);
                arr[train] = arr[train]  & ~(1<<seat);
            }
            if(order == 3) {
                arr[train] =  arr[train] <<1;
                arr[train] = arr[train] & ((1<<21)-1);
            }
            if(order ==4) {
                arr[train] = arr[train] >> 1;
                arr[train] = arr[train]& ~1;
            }
        }

        for(int i=1; i<=n; i++) {
            if(!visited[arr[i]]) {
                ans++;
                visited[arr[i]] = true;
            }
        }

        System.out.println(ans);
    }
}