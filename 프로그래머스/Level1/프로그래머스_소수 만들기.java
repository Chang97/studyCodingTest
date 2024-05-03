// 개발중
class Solution {
    public int solution(int[] nums) {
        int[] arr = new int[3001];
        int answer = -1;
        
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }
        
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (arr[sum] != 0) answer++;
                }
            }
        }

        return answer;
    }
}