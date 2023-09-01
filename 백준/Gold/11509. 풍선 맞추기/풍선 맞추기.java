import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<Integer, Integer> arrows = new HashMap<>();

        int N = s.nextInt();
        int[] balloons = new int[N];

        for(int i = 0; i < N; i++) {
            balloons[i] = s.nextInt();
            arrows.put(balloons[i], 0);
        }

        int arrow = 0;

        for(int i = 0; i < N; i++) {
            if(arrows.get(balloons[i]) > 0)
                arrows.put(balloons[i], arrows.get(balloons[i])-1);
            else
                arrow++;
            arrows.put(balloons[i]-1, arrows.getOrDefault(balloons[i]-1, 0)+1);
        }

        System.out.println(arrow);
    }
}