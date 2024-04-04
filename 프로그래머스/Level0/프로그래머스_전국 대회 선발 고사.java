import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] tmp = new int[rank.length];
        
        for (int i = 0; i < rank.length; i++) {
            tmp[i] = rank[i];
            if (!attendance[i]) {
                rank[i] = -1;
            }
        }
        Arrays.sort(rank);
        int[] answer = new int[3];
        int cnt = 0;
        for (int i = 0; i < rank.length; i++) {
            if (cnt > 2) break;
            if (rank[i] > 0) {
                for (int j = 0; j < tmp.length; j++) {
                    if (rank[i] == tmp[j]) {
                        answer[cnt] = j;
                        cnt++;
                        break;
                    }
                }
            }
            
        }
        
        return 10000 * answer[0] + 100 * answer[1] + answer[2];
    }
}