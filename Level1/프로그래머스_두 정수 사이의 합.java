class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int s = a < b ? a : b;
        int e = a < b ? b : a;
        for (int i = s; i <= e; i++) {
            answer += i;
        }
        return answer;
    }
}