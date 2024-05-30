class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int max = arr[0];
        int cnt = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        
        while (true) {
            boolean b = true;
            for (int i = 0; i < arr.length; i++) {
                if (max * cnt % arr[i] != 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                answer = max * cnt;
                break;
            } else {
                cnt++;
            }
            
        }
        
        
        return answer;
    }
}