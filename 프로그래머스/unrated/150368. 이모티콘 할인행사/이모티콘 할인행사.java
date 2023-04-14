import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static PriorityQueue<Result> pq = new PriorityQueue<>();
    static int[] ratio;
    
    class Result implements Comparable<Result> {
        int subscribe;
        int totalIncome;
        
        public Result(int subscribe, int totalIncome) {
            this.subscribe = subscribe;
            this.totalIncome = totalIncome;
        }
        
        @Override
            public int compareTo(Result o) {
                if(subscribe < o.subscribe)
                    return 1;
                else if(subscribe > o.subscribe)
                    return -1;
                else{
                    if(totalIncome < o.totalIncome)
                        return 1;
                    else
                        return -1;
                }
            }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        visited = new boolean[emoticons.length][4];
        ratio = new int[emoticons.length];

        dfs(users, emoticons, 0);

        Result result = pq.poll();
        answer[0] = result.subscribe;
        answer[1] = result.totalIncome;

        return answer;
    }
    
     public void dfs(int[][] users, int[] emoticons, int i) {
        if(i == emoticons.length) {
            int subscribe = 0;
            int income = 0;

            for(int[] user : users) {
                int bought = 0;
                int demand = user[0];
                int goal_price = user[1];

                for(int k = 0; k < emoticons.length; k++) {
                    if(demand <= 10 * ratio[k])
                        bought += emoticons[k] * (1 - 0.1 * ratio[k]);
                }
                if(bought >= goal_price)
                    subscribe++;
                else
                    income += bought;
            }
            pq.add(new Result(subscribe, income));
        }
         
        else {
            for (int k = 0; k < 4; k++) {
                if (!visited[i][k]) {
                    visited[i][k] = true;
                    ratio[i] = k+1;
                    dfs(users, emoticons, i + 1);
                    visited[i][k] = false;
                }
            }
        }
    }
}