import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        parent = new int[n+1];

        for(int i = 0; i <= n; i++)
            parent[i] = i;

        while(m-- > 0) {
            int op = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();

            if(op == 0)
                union(a,b);
            else
                System.out.println(find(a) == find(b) ? "YES" : "NO");
        }
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if(A <= B)
            parent[B] = A;
        else
            parent[A] = B;
    }

    static int find(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}