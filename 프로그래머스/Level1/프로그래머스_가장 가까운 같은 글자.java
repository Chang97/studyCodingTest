class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] numIdx = new int[(int)'z' - (int)'a' + 1];
        
        for (int i = 0; i < numIdx.length; i++) {
            numIdx[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (numIdx[(int)s.charAt(i) - 'a'] == -1) {
                numIdx[(int)s.charAt(i) - 'a'] = i;
                answer[i] = -1;
            } else {
                answer[i] = i - numIdx[(int)s.charAt(i) - 'a'];
                numIdx[(int)s.charAt(i) - 'a'] = i;
            }
        }
        
        return answer;
    }
}