import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        List<Integer> gyul = Arrays.stream(tangerine).boxed().collect(Collectors.toList());
        
        List<Integer> freq = gyul.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .stream()
                .map(Long::intValue)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        
        // List<Integer> freq = gyul.stream()
        //     .distinct()
        //     .map(t -> Collections.frequency(gyul, t))
        //     .sorted(Comparator.reverseOrder())
        //     .collect(Collectors.toList());

        for(int i = 0; k > 0; i++) {
            k -= freq.get(i);
            answer++;
        }
        
        return answer;
    }
}