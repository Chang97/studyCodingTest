class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i < myString.length();) {
            myString = myString.substring(i);
            int index = myString.indexOf(pat);
            if (index == -1) break;
            i = index + 1;
            ++answer;
        }
        return answer;
    }
}