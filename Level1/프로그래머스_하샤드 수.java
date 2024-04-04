class Solution {
    public boolean solution(int x) {
        String[] str = String.valueOf(x).split("");
        int sum = 0;
        for (String n : str) {
            sum += Integer.parseInt(n);
        }
        
        return x % sum == 0;
    }
}