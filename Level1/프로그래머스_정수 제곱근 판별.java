class Solution {
    public long solution(long n) {
        long answer = -1;
        double sqrt = Math.sqrt(n);
        if (sqrt == ((int)sqrt)) {
            answer = (long)(sqrt + 1) * (long)(sqrt + 1);
        }
        
        return answer;
    }
}