import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i = 0; i < str1.length()-1; i++) {
            String s = str1.substring(i, i+2).toLowerCase();
            if(s.matches("^[a-z]*$"))
                list1.add(s);
        }

        for(int i = 0; i < str2.length()-1; i++){
            String s = str2.substring(i, i+2).toLowerCase();
            if(s.matches("^[a-z]*$"))
                list2.add(s);
        }

        int unionCount = list1.size() + list2.size();
        int sameCount = 0;
        
        for(String s1 : list1){
            if(list2.contains(s1)) {
                list2.remove(s1);
                sameCount++;
            }
        }

        unionCount -= sameCount;
        return (sameCount == 0 && unionCount == 0) ? 65536 : 65536 * sameCount / unionCount;
    }
}