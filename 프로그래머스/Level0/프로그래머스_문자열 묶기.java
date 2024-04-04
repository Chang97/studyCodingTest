import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        List<Integer> lenArr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (String str : strArr) {
            int len = str.length();
            lenArr.add(len);
            set.add(len);
        }
        
        int max = 0;
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            max = Math.max(max, Collections.frequency(lenArr, itr.next()));
        }
        
        return max;
    }
}