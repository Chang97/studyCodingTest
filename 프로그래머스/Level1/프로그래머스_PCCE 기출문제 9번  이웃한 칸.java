class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int minHeight = h == 0 ? 0 : h - 1;
        int maxHeight = h == board.length - 1 ? board.length - 1 : h + 1;
        int minWidth = w == 0 ? 0 : w - 1;
        int maxWidth = w == board[0].length - 1 ? board[0].length - 1 : w + 1;
        
        // 상하
        for (int i = minHeight; i <= maxHeight; i++) {
            if (i != h && board[i][w].equals(board[h][w])) {
                answer++;
            }
        }
        // 좌우
        for (int i = minWidth; i <= maxWidth; i++) {
            if (i != w && board[h][i].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}