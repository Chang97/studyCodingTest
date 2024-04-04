import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int[] beforeArr = new int[arr.length];
        int cnt = 0;
        while (true) {
            beforeArr = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) arr[i] = arr[i] / 2;
                else if (arr[i] <= 50 && arr[i] % 2 != 0) arr[i] = (arr[i] * 2) + 1;
            }
            if (Arrays.equals(beforeArr, arr)) {
                break;
            }
            cnt++;
        }
        
        return cnt;
    }
}