class Solution {
    public String solution(String n_str) {
        char[] arr = n_str.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                return n_str.substring(i, n_str.length());
            }
        }
        return "";
    }
}