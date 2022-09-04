class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int sum = 0;
        
        char[] parenthesis = s.toCharArray();
        for(char c : parenthesis){
            switch (c){
                case '(' -> sum++;
                case ')' -> sum--;
            }
            if(sum < 0) break;
        }
        if(sum != 0) answer = false;
        
        return answer;
    }
}