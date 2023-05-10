class Solution {
    
    int[] peach;
    int[] ryan;
    int[] answer;
    int N, maxScore = -1;
    
    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        ryan = new int[11];
        peach = info;
        N = n;
        
        dfs(0);
        
        return answer;
    }
    
    void dfs(int i) {
        if(i == N) {
            int rScore = 0, pScore = 0;
            for(int k = 0; k <= 10; k++) {
                if(peach[k] != 0 || ryan[k] != 0) {
                    if(ryan[k] > peach[k])
                        rScore += 10-k;
                    else pScore += 10-k;
                }
            }
            if(rScore > pScore) {
                if(maxScore <= rScore-pScore) {
                    answer = ryan.clone();
                    maxScore = rScore-pScore;
                }
            }
        }
        else {
            for(int j = 0; j <= 10 && ryan[j] <= peach[j]; j++) {
                ryan[j]++;
                dfs(i+1);
                ryan[j]--;
            }
        }
    }
}