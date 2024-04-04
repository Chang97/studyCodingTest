class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuffer sb = new StringBuffer();
        char[] arr = my_string.toCharArray();
        
        for (int i : index_list) {
            sb.append(Character.toString(arr[i]));
        }
        return sb.toString();
    }
}