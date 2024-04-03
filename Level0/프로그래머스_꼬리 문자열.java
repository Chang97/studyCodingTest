class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : str_list) {
            if (str.indexOf(ex) == -1) sb.append(str);
        }
        return sb.toString();
    }
}