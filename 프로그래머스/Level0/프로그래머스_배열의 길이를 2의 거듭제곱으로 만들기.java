class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int len = arr.length == 1 ? 1 : 2;
        while (arr.length > len) {
            len *= 2;
        }
        answer = new int[len];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        
        return answer;
    }
}