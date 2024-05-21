class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt = cnt + 1;
            if (c == ')') cnt = cnt - 1;
            if (cnt < 0) return false;
        }

        return cnt == 0;
    }
}