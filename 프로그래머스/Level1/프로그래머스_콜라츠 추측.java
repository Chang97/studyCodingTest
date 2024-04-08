class Solution {
    public int solution(int num) {
        long answer = num;
        if (num == 1) return 0;
        for (int i = 1; i <= 500; i++) {
            if (answer % 2 == 0) {
                answer /= 2;
            } else {
                answer = answer * 3 + 1;
            }
            if (answer == 1) return i;
        }
        return -1;
    }
}