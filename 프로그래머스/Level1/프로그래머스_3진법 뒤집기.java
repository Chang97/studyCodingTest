class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(String.valueOf(n % 3));
            n /= 3;
        }
        int p = 0;
        for (int i = sb.length() - 1; i >= 0; i--, p++) {
            answer += (sb.charAt(i) - '0') * Math.pow(3, p);
        }
        return answer;
    }
}