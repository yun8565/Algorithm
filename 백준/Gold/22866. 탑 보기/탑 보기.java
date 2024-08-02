import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Pair[] count = new Pair[N];
        int[] buildings = new int[N];

        for (int i = 0; i < N; i++) {
            count[i] = new Pair(0,0, -1);
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(input[i]);
        }

        for(int i = 1; i < N; i++) {
            if(buildings[i-1] > buildings[i]) {
                count[i].leftCnt = count[i-1].leftCnt + 1;
                count[i].closest = i-1;
                continue;
            }
            int temp = i;
            while(temp > 0 && buildings[temp-1] <= buildings[i])
                temp--;
            if(temp > 0) {
                count[i].leftCnt = count[temp-1].leftCnt + 1;
                count[i].closest = temp-1;
            }
        }

        for(int i = N-2; i >= 0; i--) {
            if(buildings[i+1] > buildings[i]) {
                count[i].rightCnt = count[i+1].rightCnt + 1;
                if(count[i].closest < 0)
                    count[i].closest = i+1;
                else if(i - count[i].closest > 1)
                    count[i].closest = i+1;
                continue;
            }
            int temp = i;
            while(temp < N-1 && buildings[temp+1] <= buildings[i]) {
                temp++;
            }
            if(temp < N-1) {
                count[i].rightCnt = count[temp+1].rightCnt + 1;
                if(count[i].closest < 0)
                    count[i].closest = temp+1;
                else if(i-count[i].closest > temp+1-i)
                    count[i].closest = temp+1;
            }
        }

        for(Pair p : count) {
            int sum = p.leftCnt + p.rightCnt;
            System.out.println(sum > 0 ? sum+" "+(p.closest+1) : sum);
        }
    }

    static class Pair {
        int leftCnt, rightCnt, closest;
        public Pair(int leftCnt, int rightCnt, int closest) {
            this.leftCnt = leftCnt;
            this.rightCnt = rightCnt;
            this.closest = closest;
        }
    }
}