class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n + 1];
        int answer = 0;
        
        for (int num : lost) { student[num]--; }
        for (int num : reserve) { student[num]++; }
        
        // 첫번째 처리
        if (student[1] == -1 && student[2] == 1) {
            student[1]++;
            student[2]--;
        }
        // 마지막 처리
        if (student[n] == -1 && student[n - 1] == 1) {
            student[n]++;
            student[n - 1]--;
        }
        
        for (int i = 2; i < n; i++) {
            if (student[i] == -1) {
                if (student[i - 1] == 1) {
                    student[i - 1]--;
                    student[i]++;
                } else if (student[i + 1] == 1) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (student[i] > -1) {
                answer++;
            }
        }
        
        return answer;
    }
}