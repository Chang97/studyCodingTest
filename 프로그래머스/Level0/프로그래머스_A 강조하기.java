class Solution {
    public String solution(String myString) {
        char[] arr = myString.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.compare(arr[i], 'a') == 0) {
                arr[i] = 'A';
            }
        }
        return String.valueOf(arr);
    }
}