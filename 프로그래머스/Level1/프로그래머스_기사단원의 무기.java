class Solution {
    public int solution(int number, int limit, int power) {
        int[] arr = new int[number + 1];
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j <= number; j = j + i) {
                arr[j]++;
            }
        }
        
        for (int i = 1; i < arr.length; i++) {
            int p = arr[i] > limit ? power : arr[i];
            answer += p;
        }
        return answer;
    }
}