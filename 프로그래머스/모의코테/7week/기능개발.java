import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int len = speeds.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int a = (100 - progresses[i]);
            arr[i] = a / speeds[i] + (a % speeds[i] > 0 ? 1 : 0);
        }
        
        for (int i = 0; i < len; i++) {
            if (arr[i] == -1) continue;
            int cnt = 1;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (arr[j] == -1) continue;
                
                if (arr[i] >= arr[j]) {
                    arr[j] = -1;
                    cnt++;
                } else {
                    break;   
                }
            }
            arr[i] = -1;
            list.add(cnt);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}