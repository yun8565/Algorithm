import java.util.*;

class Solution{
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            answer += check(s) ? 1 : 0;
            s = s.substring(1) + s.substring(0,1);
        }
        return answer;
    }

    public boolean check(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(current == '{' || current == '(' || current == '[')
                st.push(current);
            else{
                if(st.empty()) return false;
                if(switch (st.pop()){
                    case '(' -> current != ')';
                    case '{' -> current != '}';
                    case '[' -> current != ']';
                    default -> false;
                }) return false;
            }
        }
        return st.empty();
    }
}
