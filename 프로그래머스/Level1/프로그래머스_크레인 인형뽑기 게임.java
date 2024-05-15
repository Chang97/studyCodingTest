import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            int num = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][num] == 0) continue;
                stack.push(board[j][num]);
                board[j][num] = 0;
                if (stack.size() >= 2) {
                    int size = stack.size();
                    if (stack.get(size - 1) == stack.get(size - 2)) {
                        stack.pop();
                        stack.pop();
                        answer += 2;
                    }
                }
                break;
            }
        }
        return answer;
    }
}