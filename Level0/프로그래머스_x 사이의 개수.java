import java.util.*;
class Solution {
    public int[] solution(String myString) {
        String[] strArr = myString.split("x");
        if (myString.endsWith("x")) {
            String[] newArr = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, newArr, 0, strArr.length);
            newArr[strArr.length] = "";
            strArr = newArr;
        }
        return Arrays.stream(strArr).map(val -> val.length()).mapToInt(Integer::intValue).toArray();
    }
}