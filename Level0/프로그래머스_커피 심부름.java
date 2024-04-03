class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String menu : order) {
            if (menu.indexOf("cafelatte") != -1) answer += 5000;
            else answer += 4500;
        }
        return answer;
    }
}