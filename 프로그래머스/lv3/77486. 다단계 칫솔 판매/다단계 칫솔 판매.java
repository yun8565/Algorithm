import java.util.*;

class Solution {
    class Node {
        Node parent;
        int profit;
        public Node(Node parent){
            this.parent = parent;
            this.profit = 0;
        }
        public boolean isTop(){
            return this.parent == null;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Node> tree = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            if(referral[i].equals("-"))
                tree.put(enroll[i], new Node(null));
            else
                tree.put(enroll[i], new Node(tree.get(referral[i])));
        }
        
        for(int i = 0; i < amount.length; i++) {
            Node cur = tree.get(seller[i]);
            int profit = amount[i]*100;
                
            while(!cur.isTop()) {
                if(profit < 10)
                    break;
                
                cur.profit += (profit - profit/10);
                profit /= 10;
                cur = cur.parent;
            }
            cur.profit += (profit < 10) ? profit : profit - profit/10;
        }
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = tree.get(enroll[i]).profit;
        }
    
        return answer;
    }
}