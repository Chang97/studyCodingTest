class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int[] answer = new int[sb.length()];
        sb.reverse();
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        return answer;
    }
}