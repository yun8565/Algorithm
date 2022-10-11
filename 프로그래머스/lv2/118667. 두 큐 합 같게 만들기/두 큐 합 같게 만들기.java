import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        List<Long> list = new ArrayList<>();
        long sum1 = 0, sum2 = 0;
        int answer = 0;

        for(int i = 0 ; i < queue1.length ; i++){
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
        }
        long target = (sum1 + sum2) / 2;

        if(sum1 == sum2) return 0;
        else if((sum1 + sum2) % 2 != 0) return -1;
        else if(sum2 > sum1) return solution(queue2, queue1);

        for (int i : queue1) list.add((long)i);
        for (int i : queue2) list.add((long)i);
        for (int i : queue1) list.add((long)i);
        for (int i : queue2) list.add((long)i);

        int i = 0, j = queue1.length;

        while(i != j && i < queue1.length * 2 && j < list.size()){
            while(sum1 > target && i < queue1.length * 2){
                sum1 -= list.get(i++);
                answer++;
            }
            while(sum1 < target && j < list.size()){
                sum1 += list.get(j++);
                answer++;
            }
            if(sum1 == target)
                return answer;
        }
        return -1;
    }
}