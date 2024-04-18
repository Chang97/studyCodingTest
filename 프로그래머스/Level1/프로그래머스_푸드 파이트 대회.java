class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(String.valueOf(i));
            }
        }
        answer.append(sb.toString());
        answer.append("0");
        sb.reverse();
        answer.append(sb.toString());
        return answer.toString();
    }
}