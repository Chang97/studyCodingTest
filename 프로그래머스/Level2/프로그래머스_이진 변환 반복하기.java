class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            answer[0]++;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '0') {
                    answer[1]++;
                    arr[i] = ' ';
                }
            }
            s = String.valueOf(arr).replace(" ", "");
            int len = s.length();
            s = Integer.toBinaryString(len);
        }
        return answer;
    }
}