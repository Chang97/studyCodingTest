class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        char[] strArr = code.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (i % q == r) sb.append(Character.toString(strArr[i]));
        }
        return sb.toString();
    }
}