import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            boolean isDelete = false;
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    isDelete = true;
                    break;
                }
            }
            if (!isDelete) list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}