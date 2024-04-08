class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length() % 2 == 0 ? s.length() / 2 - 1 : s.length() / 2;
        if (s.length() % 2 == 0) answer = s.substring(len, len + 2);
        else answer = s.substring(len, len + 1);
        
        return answer;
    }
}