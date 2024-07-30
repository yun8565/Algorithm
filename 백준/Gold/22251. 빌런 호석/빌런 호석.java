import java.util.*;

public class Main {

    static int floor, digit, max, cur;
    static List<Display> numbers = new ArrayList<>();
    static int[][] changes = new int[10][10];
    static int answer = 0;
    static String start;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        floor = s.nextInt(); //N
        digit = s.nextInt(); //K
        max = s.nextInt();   //P
        cur = s.nextInt();   //X

        numbers.add(new Display(new int[]{1,1,1,0,1,1,1})); //0
        numbers.add(new Display(new int[]{0,0,1,0,0,1,0})); //1
        numbers.add(new Display(new int[]{1,0,1,1,1,0,1})); //2
        numbers.add(new Display(new int[]{1,0,1,1,0,1,1})); //3
        numbers.add(new Display(new int[]{0,1,1,1,0,1,0})); //4
        numbers.add(new Display(new int[]{1,1,0,1,0,1,1})); //5
        numbers.add(new Display(new int[]{1,1,0,1,1,1,1})); //6
        numbers.add(new Display(new int[]{1,0,1,0,0,1,0})); //7
        numbers.add(new Display(new int[]{1,1,1,1,1,1,1})); //8
        numbers.add(new Display(new int[]{1,1,1,1,0,1,1})); //9

        // led 차이 계산
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int[] first = numbers.get(i).segment;
                int[] second = numbers.get(j).segment;
                int diff = 0;
                for(int k = 0; k < 7; k++) {
                    if(first[k] != second[k])
                        diff++;
                }
                changes[i][j] = diff;
            }
        }
        start = String.valueOf(cur);
        String zero = "0".repeat(digit-start.length());
        start = zero.concat(start);

        dfs("", 0);
        System.out.println(answer);
    }

    static void dfs(String num, int sum) {
        if(num.length() == digit) {
            if(sum > 0 && sum <= max && Integer.parseInt(num) <= floor) {
                if(!num.replaceAll("0", "").isEmpty())
                    answer++;
            }
            return;
        }
        for(int k = 0; k < 10; k++) {
            dfs(num + k, sum + changes[start.charAt(num.length())-'0'][k]);
        }
    }

    static class Display {
        int[] segment;

        public Display(int[] segment) {
            this.segment = segment;
        }
    }
}