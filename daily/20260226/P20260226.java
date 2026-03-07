import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        
        for (int i = 0; i < days.length; i++) {
            days[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        int cnt = 1;
        for (int i = 1; i < days.length; i++) {
            if (days[i] > days[cur]) {
                list.add(cnt);
                cur = i;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}