class Solution {
    
    int answer = 0;
    boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        
        visited = new boolean[numbers.length];
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int i, int sum) {
        
        if(i == numbers.length) {
            if(sum == target)
                answer++;
        }
        else {
            for(int k = 0; k < 2; k++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(numbers, target, i+1, k==0 ? sum+numbers[i] : sum-numbers[i]);
                    visited[i] = false;
                }
            }
        }
    }
}