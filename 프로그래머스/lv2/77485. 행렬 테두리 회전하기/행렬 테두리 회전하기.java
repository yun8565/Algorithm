class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int num = 1;
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int[][] nextMap = new int[rows][columns];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            for(int j = 0; j < rows; j++)
                for(int k = 0; k < columns; k++)
                    nextMap[j][k] = map[j][k];
            
            for(int j = x1; j <= x2; j++) {
                for(int k = y1; k <= y2; k++) {
                    if(j == x1 && k < y2){
                        nextMap[j][k+1] = map[j][k];  
                        min = Math.min(min, map[j][k]);
                    }
                    if(j == x2 && k < y2){
                        nextMap[j][k] = map[j][k+1];
                        min = Math.min(min, map[j][k+1]);
                    }
                    if(k == y1 && j < x2){
                        nextMap[j][k] = map[j+1][k];
                        min = Math.min(min, map[j+1][k]);
                    }
                    if(k == y2 && j < x2){
                        nextMap[j+1][k] = map[j][k];
                        min = Math.min(min, map[j][k]);
                    }
                }
            }
            
            for(int j = 0; j < rows; j++)
                for(int k = 0; k < columns; k++)
                    map[j][k] = nextMap[j][k];

            answer[i] = min;
        }
        
        return answer;
    }
}