class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] charArr = my_string.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int num = (int)'a' > (int)charArr[i] ? 65 : 71;
            answer[(int)charArr[i]  - num]++;
        }
        return answer;
    }
}