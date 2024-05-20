class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int[] dmg = new int[attacks[attacks.length - 1][0] + 1];
        int hp = health;
        int cnt = 1;
        
        for (int i = 0; i < attacks.length; i++) {
            dmg[attacks[i][0]] = dmg[attacks[i][0]] - attacks[i][1];
        }
        
        for (int i = 1; i < dmg.length; i++) {
            if (dmg[i] >= 0) {
                cnt++;
                if (cnt % bandage[0] == 0) dmg[i] += bandage[2];
                dmg[i] += bandage[1];
            } else {
                cnt = 0;
            }
        }
        
        for (int i = 1; i < dmg.length; i++) {
            hp = hp + dmg[i] > health ? health : hp + dmg[i];
            if (hp <= 0) return -1;
        }
        return hp;
    }
}