class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        StringBuilder x = new StringBuilder();
        StringBuilder dot = new StringBuilder();
        
        for (int j = 0; j < k; j++) {
            x.append("x");
            dot.append(".");
        }

        for (int i = 0; i < picture.length; i++) {
            picture[i] = picture[i].replace("x", x.toString());
            picture[i] = picture[i].replace(".", dot.toString());
            for (int j = 0; j < k; j++) {
                answer[(i * k) + j] = picture[i];
            }
        }
        return answer;
    }
}