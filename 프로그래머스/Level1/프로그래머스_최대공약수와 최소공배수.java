class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n, m);
        
        for (int i = 1; i <= max; i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        
        for (int i = 1;; i++) {
            if (max * i % n == 0 && max * i % m == 0) {
                answer[1] = max * i;
                break;
            }
        }
        
        return answer;
    }
}