class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int s = brown + yellow;
        int w = 3;
        int h = 3;
        
        while (true) {
            int y = (w - 2) * (h - 2);
            int b = s - y;
            if (s == w * h && y == yellow && b == brown) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
            
            if (w * h > s) {
                h++;
                w = h;
            } else {
                w++;
            }
        }
        
        return answer;
    }
}