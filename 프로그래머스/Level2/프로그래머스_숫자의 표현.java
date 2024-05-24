class Solution {
    public int solution(int n) {
        if (n <= 2) return 1;
        int answer = 1;
        int s = 1;
        int e = 1;
        int sum = 1;
        
        while (s <= n / 2 + 1) {
            if (sum < n) {
                e++;
                sum += e;
            } else if (sum > n) {
                sum -= s;
                s++;
            } else {
                answer++;
                sum -= s;
                s++;
            }
        }
        
        return answer;
    }
}