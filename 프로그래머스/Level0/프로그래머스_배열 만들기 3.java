import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> numArr = new ArrayList<>();
        
        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            numArr.add(arr[i]);
        }
        for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            numArr.add(arr[i]);
        }
        return numArr.stream().mapToInt(Integer::intValue).toArray();
    }
}