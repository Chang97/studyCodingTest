class Solution {
    public boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)) return false;
        boolean answer = true;
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            if (!Character.isDigit(c)) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}