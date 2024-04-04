import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int s = -1, e = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (s == -1) {
                    s = i;
                } else {
                    e = i;
                }
            }
        }
        if (s == -1) {
            return new int[]{-1};
        }
        if (e == -1) {
            return new int[]{2};
        }
        return Arrays.copyOfRange(arr, s, e + 1);
    }
}