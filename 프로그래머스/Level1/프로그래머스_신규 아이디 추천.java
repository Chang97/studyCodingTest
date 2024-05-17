class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        // 1
        answer = answer.toLowerCase();
        // 2
        answer = answer.replaceAll("[^a-z0-9\\-_.]", "");
        // 3
        while (true) {
            answer = answer.replace("..", ".");
            if (answer.indexOf("..") == -1) {
                break;
            }
        }
        
        // 4
        if (answer.indexOf(".") == 0 ) answer = answer.replaceFirst(".", "");
        if (answer.length() != 0) {
            if (answer.lastIndexOf(".") == answer.length() - 1) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        // 5
        if (answer.length() == 0) {
            answer = "a";
        }
        // 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.lastIndexOf(".") == answer.length() - 1) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        // 7
        if (answer.length() <= 2) {
            String c = answer.substring(answer.length() - 1, answer.length());
            for (int i = answer.length(); i < 3; i++) {
                answer += c;
            }
        }
        
        
        
        return answer;
    }
}