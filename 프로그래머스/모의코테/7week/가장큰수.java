import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        for (String str : list) {
            sb.append(str);
        }
        
        if (sb.substring(0, 1).equals("0")) return "0";
        else return sb.toString();
        
    }
}