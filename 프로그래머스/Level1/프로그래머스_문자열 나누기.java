class Solution {
    public int solution(String s) {
        int answer = 0;
        int hit = 0;
        int miss = 0;
        char x = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (x == s.charAt(i)) {
                hit++;
            } else {
                miss++;
            }
            
            if (hit == miss) {
                answer++;
                hit = 0;
                miss = 0;
                x = i != s.length() - 1 ? s.charAt(i + 1) : 'x';
            } else {
                if (i == s.length() - 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}