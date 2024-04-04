import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(val -> k % 2 == 0 ? val + k : val * k).toArray();
    }
}