class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                cnt = 0;
                continue;
            }
            if (cnt % 2 == 0) {
                arr[i] = Character.toUpperCase(arr[i]);
            } else {
                arr[i] = Character.toLowerCase(arr[i]);
            }
            cnt++;
        }
        return String.valueOf(arr);
    }
}