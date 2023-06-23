import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        LinkedList<String> p = new LinkedList<>(Arrays.asList(participant));
        p.sort(Comparator.naturalOrder());
        Arrays.sort(completion);
        
        for(String player : completion) {
            p.remove(player);
        }
        
        return p.get(0);
    }
}