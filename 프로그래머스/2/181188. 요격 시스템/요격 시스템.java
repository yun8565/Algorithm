import java.util.*;

class Solution {

    public int solution(int[][] targets) {
        int answer = 0;

       Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int start = 0;
        
        for(int[] t : targets) {
            if(start <= t[0]) {
                start = t[1];
                answer++;
            }
        }

        return answer;
    }
}