class Solution {
    
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    Pair left, right;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        left = new Pair(3,0);
        right = new Pair(3,2);
        
        for(int n : numbers) {
            Pair nLoc = n == 0 ? new Pair(3,1) : new Pair((n-1)/3, (n-1)%3);
            int ldist = distance(left, nLoc);
            int rdist = distance(right, nLoc);
            
            if(n == 1 || n == 4 || n == 7) {
                answer += "L";
                left.set(nLoc.x, nLoc.y);
            }
            else if(n == 3 || n == 6 || n == 9) {
                answer += "R";
                right.set(nLoc.x, nLoc.y);
            }
            else {
                if(ldist == rdist) {
                    if(hand.equals("right")) {
                        answer += "R";
                        right.set(nLoc.x, nLoc.y);
                    }
                    else {
                        answer += "L";
                        left.set(nLoc.x, nLoc.y);
                    }
                }
                else if(ldist < rdist) {
                    answer += "L";
                    left.set(nLoc.x, nLoc.y);
                }
                else {
                    answer += "R";
                    right.set(nLoc.x, nLoc.y);
                }   
            }
        }
        
        return answer;
    }
    
    public int distance(Pair finger, Pair num) {
        return Math.abs(finger.x - num.x) + Math.abs(finger.y - num.y);
    }
}