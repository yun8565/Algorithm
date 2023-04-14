import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> termMap = new HashMap<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, df);
        
        for(String term : terms)
            termMap.put(term.charAt(0), Integer.parseInt(term.substring(2)));
        
        for(int i = 0; i < privacies.length; i++) {
            LocalDate date = LocalDate.parse(privacies[i].substring(0,10), df);
            int expiration = termMap.get(privacies[i].charAt(11));
            if(todayDate.isAfter(date.plusMonths(expiration)) || todayDate.isEqual(date.plusMonths(expiration)))
                result.add(i+1);
        }
        
        return result.stream().mapToInt(n->n).sorted().toArray();
    }
}