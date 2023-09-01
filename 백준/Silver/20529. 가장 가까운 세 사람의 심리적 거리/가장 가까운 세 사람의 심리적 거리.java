import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            int N = s.nextInt();
            String[] mbti = new String[N];
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < N; j++)
                mbti[j] = s.next();

            if(N >= 33)
                System.out.println(0);
            else {
                for(int k = 0; k < N; k++)
                    for(int kk = k+1; kk < N; kk++)
                        for(int kkk = kk+1; kkk < N; kkk++)
                            min = Math.min(min, getScore(mbti[k], mbti[kk], mbti[kkk]));
                System.out.println(min);
            }
        }
    }

    static int getScore(String A, String B, String C) {
        int score = 0;
        for(int i = 0; i < 4; i++) {
            if(A.charAt(i) != B.charAt(i))
                score++;
            if(B.charAt(i) != C.charAt(i))
                score++;
            if(A.charAt(i) != C.charAt(i))
                score++;
        }
        return score;
    }
}