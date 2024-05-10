class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int hit = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    hit++;
                    break;
                }
            }
        }
        
        int max = getRank(hit + zero);
        int min = getRank(hit);
        
        return new int[] {max, min};
    }
    
    public static int getRank(int hit) {
        int rank = 0;
        switch (hit) {
            case 2 :
                rank = 5;
                break;
            case 3 :
                rank = 4;
                break;
            case 4 :
                rank = 3;
                break;
            case 5 :
                rank = 2;
                break;
            case 6 :
                rank = 1;
                break;
            default :
                rank = 6;
                break;
        }
        return rank;
    }
}