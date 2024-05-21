class Solution {
    public String solution(String s) {
        String[] parts = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str : parts) {
            int num = Integer.parseInt(str);
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return min + " " + max;
    }
}