import java.util.*;

public class Main {

    static List<String> tuple = new ArrayList<>();
    static String[] mbti;
    static int min, N;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            N = s.nextInt();
            mbti = new String[N];
            min = Integer.MAX_VALUE;
            tuple.clear();

            for(int j = 0; j < N; j++)
                mbti[j] = s.next();

            if(N >= 33) {
                System.out.println(0);
                continue;
            }

            dfs(0, 0);
            System.out.println(min);
        }
    }

    static void dfs(int k, int depth) {
        if (depth == 3) {
            int score = getScore(tuple.get(0), tuple.get(1), tuple.get(2));
            min = Math.min(min, score);
        }
        else {
            for (int i = k; i < N; i++) {
                tuple.add(mbti[i]);
                dfs(i + 1, depth + 1);
                tuple.remove(tuple.size() - 1);
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
