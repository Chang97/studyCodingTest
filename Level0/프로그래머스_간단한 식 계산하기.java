class Solution {
    public int solution(String binomial) {
        String[] answer = binomial.split(" ");
        if (answer[1].equals("+")) return Integer.parseInt(answer[0]) + Integer.parseInt(answer[2]);
        if (answer[1].equals("-")) return Integer.parseInt(answer[0]) - Integer.parseInt(answer[2]);
        if (answer[1].equals("*")) return Integer.parseInt(answer[0]) * Integer.parseInt(answer[2]);
        return 0;
    }
}