class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String str : babbling) {
            String tmp = new String(str);
            for (String balum : arr) {
                if (str.indexOf(balum + balum) != -1) break;
                tmp = tmp.replace(balum, " ");
            }
            tmp = tmp.replace(" ", "");
            if (tmp.length() == 0) answer++;
        }
        return answer;
    }
}