import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        Integer[] list = set.toArray(Integer[]::new);
        for (int i = 0; i < answer.length; i++) {
            if (set.size() - 1 < i) {
                answer[i] = -1;
            } else {
                answer[i] = list[i];
            }
        }
        return answer;
    }
}