class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];
        
        for (char c : X.toCharArray()) { x[c - '0']++; }
        for (char c : Y.toCharArray()) { y[c - '0']++; }
        
        for (int i = 9; i >= 0; i--) {
            int num = Math.min(x[i], y[i]);
            if (num != 0) {
                if (i == 0 && answer.length() == 0) return "0";
                for (int j = 0; j < num; j++) {
                    answer.append(i);
                }
            }
        }
        if (answer.length() == 0) return "-1";
        return answer.toString();
    }
}