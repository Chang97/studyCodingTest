import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] arr = t.toCharArray();
        char[] part = new char[p.length()];
        int e = p.length();
        for (int i = 0; i < arr.length - e + 1; i++) {
            part = Arrays.copyOfRange(arr, i, part.length + i);
            String partition = String.valueOf(part);
            if (Long.parseLong(partition) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}