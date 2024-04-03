class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cnt = 0;
        int startRowIdx = 0;
        int startColIdx = 0;
        int endRowIdx = n - 1;
        int endColIdx = n - 1;
        int direction = 1;
        
        while (true) {
            if (direction == 1) {
                for (int i = startColIdx; i <= endColIdx; i++) {
                    answer[startRowIdx][i] = ++cnt;
                }
                startRowIdx++;
                direction = 2;
            } else if (direction == 2) {
                for (int i = startRowIdx; i <= endRowIdx; i++) {
                    answer[i][endColIdx] = ++cnt;
                }
                endColIdx--;
                direction = 3;
            } else if (direction == 3) {
                for (int i = endColIdx; i >= startColIdx; i--) {
                    answer[endRowIdx][i] = ++cnt;
                }
                endRowIdx--;
                direction = 4;
            } else {
                for (int i = endRowIdx; i >= startRowIdx; i--) {
                    answer[i][startColIdx] = ++cnt;
                }
                startColIdx++;
                direction = 1;
            }
            
            if (cnt == n * n) break;
            
        }
        
        return answer;
    }
}