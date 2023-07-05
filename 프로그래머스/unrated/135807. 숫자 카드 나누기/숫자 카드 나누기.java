import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        checkRule(arrayA, arrayB);
        checkRule(arrayB, arrayA);
        
        return answer;
    }
    
    public void checkRule(int[] cards1, int[] cards2) {
        int min = Arrays.stream(cards1).min().getAsInt();
        List<Integer> cm = new ArrayList<>();
        
        for(int i = 2; i <= min; i++) {
            boolean isCm = true;
            for(int n : cards1) {
                if(n % i != 0) {
                    isCm = false;
                    break;
                }
            }
            if(isCm)
                cm.add(i);
        }
        
        for(int n : cm) {
            boolean isNotCm = true;
            for(int i : cards2) {
                if(i % n == 0) {
                    isNotCm = false;
                    break;
                }
            }
            if(isNotCm)
                answer = Math.max(answer, n);
        }
    }
}