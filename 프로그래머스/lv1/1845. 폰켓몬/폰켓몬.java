import java.util.*;

class Solution {
    public int solution(int[] nums) {

        int N = nums.length/2;        
        int distinct = (int)Arrays.stream(nums).distinct().count();
        
        return distinct > N ? N : distinct;
    }
}