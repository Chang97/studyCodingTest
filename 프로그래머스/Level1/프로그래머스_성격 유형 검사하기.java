import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> score = new HashMap<>();
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        for (char[] type : types) {
            score.put(type[0], 0);
            score.put(type[1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] == 4) continue;
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);
            
            if (choices[i] < 4) {
                score.put(type1, score.get(type1) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                score.put(type2, score.get(type2) + choices[i] - 4);
            } 
        }
        
        for (char[] type : types) {
            char type1 = type[0];
            char type2 = type[1];
            if (score.get(type1) >= score.get(type2)) {
                answer += type1;
            } else {
                answer += type2;
            }
        }
        
        return answer;
    }
}