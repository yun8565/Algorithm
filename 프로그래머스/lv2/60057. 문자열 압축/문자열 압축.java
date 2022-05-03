import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        //n(1-s.length)개 단위로 잘라서 압축했을 때 문자열의 길이 저장
        int[] lengths = new int[s.length()];

        for(int unit = 1; unit <= s.length(); unit++){
            String st = s; //압축할 임시 문자열
            String tmp = s.substring(0, unit); //앞에서부터 unit개 단위로 자른 문자열
            int count = 1; //중복 횟수 세기
            for(int i = unit; i +unit <= s.length(); i+=unit) {
                String ss = s.substring(i, i+unit);
                if(tmp.equals(ss)) count++;
                else {
                    if(count > 1) {
                        String tt = tmp.repeat(count); 
                        st = st.replaceFirst(tt, count+tmp); //반복된 문자열 압축하기
                    }
                    tmp = ss;
                    count = 1;
                }
            } //압축할 문자열 남아있으면 마저 압축
            if(count > 1) {
                String tt = tmp.repeat(count);
                st = st.replaceFirst(tt, count+tmp);
            }
            lengths[unit-1] = st.length(); //길이 저장
        }
        Arrays.sort(lengths); answer = lengths[0]; //최소 길이
        return answer;
    }
}