import java.util.*;

public class Main {

    static List<Question> questions = new ArrayList<>();
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        visited = new boolean[10];
        int N = s.nextInt();

        for(int i = 0; i < N; i++) {
            int num = s.nextInt();
            int st = s.nextInt();
            int b = s.nextInt();
            questions.add(new Question(num, st, b));
        }

        dfs("");
        System.out.println(answer);
    }

    static void dfs(String num) {
        if(num.length() == 3) {
            check(num);
            return;
        }
        for(int i = 1; i <= 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(num + i);
                visited[i] = false;
            }
        }
    }

    static void check(String possible) {
        for(Question q : questions) {
            int strike = 0, ball = 0;
            String num = q.num;

            for(int k = 0; k < 3; k++)
                if(possible.charAt(k) == num.charAt(k))
                    strike++;

            if(strike != q.strike)
                return;

            for(int k = 0; k < 3; k++)
                if(possible.charAt(k) == num.charAt((k+1)%3) || possible.charAt(k) == num.charAt((k+2)%3))
                    ball++;

            if(ball != q.ball)
                return;
        }
        answer++;
    }

    static class Question {
        String num;
        int strike, ball;
        public Question(int num, int strike, int ball) {
            this.num = String.valueOf(num);
            this.strike = strike;
            this.ball = ball;
        }
    }
}