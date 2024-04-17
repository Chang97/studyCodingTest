import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<SortString> list = new ArrayList<>();
        
        for (String str : strings) {
            list.add(new SortString(str, (int)str.charAt(n)));       
        }
        
        Collections.sort(list, new Comparator<SortString> () {
            @Override
            public int compare(SortString a, SortString b) {
                if (a.sort == b.sort) {
                    return a.str.compareTo(b.str);
                }
                return a.sort - b.sort;
            }
        });
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).str;
        }
        
        return answer;
    }
    
    public class SortString {
        public int sort;
        public String str;

        public SortString(String str, int sort) {
            this.str = str;
            this.sort = sort;
        }
    }
}