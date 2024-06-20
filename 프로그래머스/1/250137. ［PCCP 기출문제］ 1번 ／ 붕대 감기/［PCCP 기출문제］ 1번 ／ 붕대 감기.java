class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int turn = 0;
        int cons = 0;
        
        loop : for(int[] attack : attacks) {
            cons = 0;
            int attackTurn = attack[0];
            int damage = attack[1];
            
            while(turn++ < attackTurn) {
                cons++;
                health = Math.min(maxHealth, health + bandage[1]);
                
                if(cons == bandage[0]) {
                    health = Math.min(maxHealth, health + bandage[2]);
                    cons = 0;
                }
            }
            health -= damage;
            
            if(health <= 0)
                break loop;
        }
        return health <= 0 ? -1 : health;
    }
}