class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int bnum1 = Integer.bitCount(n);
        while (true) {
            int bnum2 = Integer.bitCount(answer);
            if (bnum1 == bnum2) {
                break;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}