class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match_count = 0, joker = 0;
        int[] rank = new int[]{6,6,5,4,3,2,1};
        
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                joker++;
                continue;
            }
            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j])
                    match_count++;
            }
        }
        
        answer[0] = rank[match_count + joker];
        answer[1] = rank[match_count];
        
        return answer;
    }
}