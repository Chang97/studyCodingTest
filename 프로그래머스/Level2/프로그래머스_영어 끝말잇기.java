import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] man = new int[n + 1];
        Map<String, Boolean> map = new HashMap<>();
        map.put(words[0], true);
        man[1] = 1;
        
        int num = 2;
        int cnt = 1;
        int len = words.length;
        
        while (cnt < len) {
            if (num > n) num = 1;
            man[num] = man[num] + 1;

            char c1 = words[cnt - 1].charAt(words[cnt - 1].length() - 1);
            char c2 = words[cnt].charAt(0);
            
            if (map.getOrDefault(words[cnt], false) || c1 != c2) {
                answer[0] = num;
                answer[1] = man[num];
                break;
            }
            
            map.put(words[cnt], true);
            num++;
            cnt++;
        }

        return answer;
    }
}