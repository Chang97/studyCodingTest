import java.util.*;
class Solution {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        char[] answer = new char[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[(arr.length - 1) - i];
        }
        return Long.parseLong(String.valueOf(answer));
    }
}