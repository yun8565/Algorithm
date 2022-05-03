import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp = "";
        int[] lengths = new int[s.length()];

        for(int unit = 1; unit <= s.length(); unit++){
            String st = s;
            tmp = s.substring(0, unit);
            int count = 1;
            for(int i = unit; i +unit <= s.length(); i+=unit) {
                String ss = s.substring(i, i+unit);
                if(tmp.equals(ss))
                    count++;
                else {
                    if(count > 1) {
                        String tt = tmp.repeat(count);
                        st = st.replaceFirst(tt, count+tmp);
                    }
                    tmp = ss;
                    count = 1;
                }
            }
            if(count > 1) {
                String tt = tmp.repeat(count);
                st = st.replaceFirst(tt, count+tmp);
            }
            lengths[unit-1] = st.length();
        }
        Arrays.sort(lengths);
        answer = lengths[0];
        return answer;
    }
}