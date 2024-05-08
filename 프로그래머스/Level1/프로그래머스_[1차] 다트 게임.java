class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        char[] dart = dartResult.toCharArray();
        int idx = 0;
        
        for (int i = 0; i < dart.length; i++) {
            if (Character.isDigit(dart[i])) { // 숫자인 경우
                if (Character.isDigit(dart[i + 1])) { // 10인 경우
                    score[idx] = (dart[i] - '0') * 10;
                    i++;
                } else {
                    score[idx] = (dart[i] - '0');
                }
            } else if (dart[i] == 'D') { // 2제곱
                score[idx] = (int) Math.pow(score[idx], 2);
            } else if (dart[i] == 'T') { // 3제곱
                score[idx] = (int) Math.pow(score[idx], 3);
            } else if (dart[i] == '*') {
                if (idx == 0) {
                    score[idx] = score[idx] * 2;
                } else {
                    score[idx - 1] *= 2;
                    score[idx] *= 2;
                }
            } else if (dart[i] == '#') {
                score[idx] *= -1;
            }
            
            if (idx < 2 && Character.isDigit(dart[i + 1])) idx++;   
        }
        
        for (int i = 0; i < score.length; i++) {
            
            answer += score[i];
        }
        
        return answer;
    }
}