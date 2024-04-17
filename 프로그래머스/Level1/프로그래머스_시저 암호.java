class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < s.length(); i ++) {
            if (arr[i] == ' ') 
                continue;
            char base = Character.isUpperCase(arr[i]) ? 'A' : 'a';
            arr[i] = (char) (((int)arr[i] - base + n) % 26 + base);
        }
        return String.valueOf(arr);
    }
}