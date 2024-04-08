class Solution {
    public int solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int number : numbers) {
            sb.append(String.valueOf(number));
        }
        for (int i = 0; i < 10; i++) {
            int idx = sb.indexOf(String.valueOf(i));
            if (idx == -1) {
                answer += i;
            }
        }
        
        return answer;
    }
}