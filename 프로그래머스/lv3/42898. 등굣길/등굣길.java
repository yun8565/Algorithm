class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1;
        
        for(int[] pud : puddles)
            map[pud[1]][pud[0]] = -1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == -1)
                    continue;
                if(i == 1 && j == 1)
                    continue;
                
                if(map[i-1][j] == -1) {
                    map[i][j] = map[i][j-1];
                }
                else if(map[i][j-1] == -1) {
                    map[i][j] = map[i-1][j];
                }
                else {
                    if(map[i-1][j] + map[i][j-1] > 1000000007) {
                        map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                    }
                    else 
                        map[i][j] = map[i-1][j] + map[i][j-1];
                }
            }
        }
        
        return map[n][m] % 1000000007;
    }
}