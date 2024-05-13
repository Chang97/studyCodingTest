class Solution {
    public String solution(String s, String skip, int index) {
        char[] arr = s.toCharArray();
        char[] alp = new char[('z' - 'a' + 1) - skip.length()];
        int cnt = 0;
        for (int i = 0; i < ('z' - 'a' + 1); i++) {
            char c = (char) ('a' + i);
            if (!skip.contains(String.valueOf(c))) {
                alp[i - cnt] = c;
            } else {
                cnt++;
            }
        }
        
        String strAlp = String.valueOf(alp);
        
        for (int i = 0; i < arr.length; i++) {
            int idx = strAlp.indexOf(String.valueOf(arr[i]));
            idx = (idx + index) % alp.length;
            arr[i] = (char) alp[idx];
        }
        
        return String.valueOf(arr);
    }
}