import java.util.*;

class Solution {
    
    class Pair {
        String word;
        int depth;
        
        public Pair(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 0));
        
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            
            if(cur.word.equals(target))
                answer = Math.min(answer, cur.depth);
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && canChange(cur.word, words[i])) {
                    q.add(new Pair(words[i], cur.depth+1));
                    visited[i] = true;
                }
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public boolean canChange(String from, String to) {
        int cnt = 0;
        
        for(int i = 0; i < from.length(); i++) {
            if(from.charAt(i) == to.charAt(i))
                cnt++;   
        }
        
        return cnt == from.length() - 1;
    }
}