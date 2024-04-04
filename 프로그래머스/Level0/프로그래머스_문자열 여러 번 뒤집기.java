class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        for (int[] arr : queries) {
            StringBuilder sb = new StringBuilder(answer.substring(0, arr[0]));
            sb.append(new StringBuilder(answer.substring(arr[0], arr[1] + 1)).reverse());
            sb.append(answer.substring(arr[1] + 1, my_string.length()));
            answer = sb.toString();
        }
        return answer;
    }
}