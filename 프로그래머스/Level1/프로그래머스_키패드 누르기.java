class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}  // 9
        };
        
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = keypad[num];
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = keypad[num];
            } else {
                int[] targetPos = keypad[num];
                int leftDist = Math.abs(leftPos[0] - targetPos[0]) + Math.abs(leftPos[1] - targetPos[1]);
                int rightDist = Math.abs(rightPos[0] - targetPos[0]) + Math.abs(rightPos[1] - targetPos[1]);
                if (leftDist > rightDist) {
                    rightPos = targetPos;
                    answer.append("R");
                } else if (leftDist < rightDist) {
                    leftPos = targetPos;
                    answer.append("L");
                } else {
                    if (hand.equals("left")) {
                        leftPos = targetPos;
                        answer.append("L");
                    } else {
                        rightPos = targetPos;
                        answer.append("R");
                    }
                }
                
                
            }
        }
        return answer.toString();
    }
}