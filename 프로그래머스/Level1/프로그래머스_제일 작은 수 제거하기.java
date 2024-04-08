class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        
        int[] answer = new int[arr.length - 1];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) cnt++;
            else answer[i - cnt] = arr[i];
        }
        
        return answer;
    }
}