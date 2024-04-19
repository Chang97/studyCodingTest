class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (true) {
            answer = answer + (n / a * b);
            n = (n / a * b) + (n % a);
            if (n < 2 || n < a) break;
        }
        return answer;
    }
    
}