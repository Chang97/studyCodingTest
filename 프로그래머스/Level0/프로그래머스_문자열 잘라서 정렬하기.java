import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        return Arrays.stream(answer).filter(x -> !x.equals("")).sorted().toArray(String[]::new);
    }
}