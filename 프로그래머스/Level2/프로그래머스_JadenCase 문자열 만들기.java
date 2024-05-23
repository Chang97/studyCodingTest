class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean isFirst = true;
        for (char c : arr) {
            if (isFirst) {
                answer.append(String.valueOf(Character.toUpperCase(c)));
                isFirst = false;
            } else {
                answer.append(String.valueOf(Character.toLowerCase(c)));
            }
            
            if (c == ' ') isFirst = true;
        }
            
        return answer.toString();
    }
}