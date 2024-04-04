import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        StringBuilder sb = new StringBuilder();
        char[] arr = myStr.toCharArray();
        List<String> strArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'b' || arr[i] == 'c') {
                if (sb.length() > 0) {
                    strArr.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(arr[i]);
            }
        }
        if (sb.length() > 0) strArr.add(sb.toString());
        if (strArr.size() == 0) {
            return new String[] {"EMPTY"};
        } else {
            return strArr.stream().toArray(String[]::new);
        }
    }
}