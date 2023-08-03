import java.util.*;

public class Main {

    static final int max = 100;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        boolean[][] paper = new boolean[max][max];
        int area = 0;

        int n = s.nextInt();
        for(int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            for(int ii = 0; ii < 10; ii++) {
                for(int iii = 0; iii < 10; iii++) {
                    paper[x+ii][y+iii] = true;
                }
            }
        }

        for(int i = 0; i < max; i++)
            for(int j = 0; j < max; j++)
                if(paper[i][j]) area++;
        
        System.out.println(area);
    }
}