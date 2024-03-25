import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        if (n == 1) {
            return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
        } else if (n == 2) {
            return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if (n == 3) {
            return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
        } else {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                arr.add(num_list[i]);
            }
            return arr.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}