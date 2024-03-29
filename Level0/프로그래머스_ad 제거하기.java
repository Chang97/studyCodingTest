import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr).filter(str -> str.indexOf("ad") == -1).toArray(String[]::new);
    }
}