class Solution {
    
    boolean[] skillTree;
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        skillTree = new boolean[26];
        
        for(char c : skill.toCharArray())
            skillTree[c - 'A'] = true;
        
        for(String s : skill_trees) {
            int i = 0;
            boolean flag = true;
            
            for(char c : s.toCharArray()) {
                if(skillTree[c-'A']) {
                    if(c == skill.charAt(i))
                        i++;
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}