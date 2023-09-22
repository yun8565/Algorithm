import java.util.*;

public class Main {

    static int N, K;
    static int[] belt;
    static boolean[] robot;
    static int step = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        K = s.nextInt();

        belt = new int[2*N];
        robot = new boolean[N];

        for(int i = 0; i < 2*N; i++) {
            belt[i] = s.nextInt();
        }

        boolean flag = true;
        while(flag) {
            flag = simulate();
            step++;
        }
        System.out.println(step);
    }

    static boolean simulate() {
        rotate();
        moveRobot();
        putRobot();
        return checkBelt();
    }

    static void rotate() {
        int last = belt[2*N-1];
        for(int i = 2*N-1; i >= 0; i--) {
            belt[i] = i == 0 ? last : belt[(i+(2*N-1))%(2*N)];
        }
        for(int i = N-1; i >= 0; i--) {
            robot[i] = i != 0 && robot[i - 1];
        }
        robot[N-1] = false;
    }

    static void moveRobot() {
        for(int i = N-1; i >= 0; i--) {
            if(!robot[i] && belt[i] >= 1) {
                if(i == 0) {
                    robot[i] = false;
                    continue;
                }
                robot[i] = robot[i - 1];
                belt[i] = robot[i-1] ? Math.max(0, belt[i]-1) : belt[i];
                robot[i-1] = false;
            }
            robot[N-1] = false;
        }
    }

    static void putRobot() {
        if(belt[0] > 0) {
            robot[0] = true;
            belt[0] = Math.max(belt[0]-1, 0);
        }
    }

    static boolean checkBelt() {
        int count = 0;
        for(int i = 0; i < 2*N; i++)
            if(belt[i] == 0)
                count++;
        return count < K;
    }
}