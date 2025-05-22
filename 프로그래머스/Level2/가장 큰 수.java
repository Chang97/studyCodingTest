import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] sArr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            sArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(sArr, (a, b) -> (a + b).compareTo(b + a));
        // 최대값이 0인 경우
        if (sArr[sArr.length - 1].equals("0")) return "0";
        
        StringBuffer sb = new StringBuffer();
        for (int i = sArr.length - 1; i >= 0; i--) {
            sb.append(sArr[i]);
        }
        
        return sb.toString();
        
    }
}