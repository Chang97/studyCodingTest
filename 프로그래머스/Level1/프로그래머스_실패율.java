import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        List<failRt> arr = new ArrayList<>();
        int[] clear = new int[N + 1];
        int[] lend = new int[N + 1];
        int[] answer = new int[N];
        
        for (int i = 1; i < clear.length; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) clear[i]++;
                if (stages[j] >= i) lend[i]++;
            }
        }
        for (int i = 1; i < clear.length; i++) {
            if (lend[i] == 0) {
                arr.add(new failRt(i, 0));
                continue;
            }
            arr.add(new failRt(i, (double) clear[i] / lend[i]));
        }
        
        Collections.sort(arr);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i).idx;
        }
        
        return answer;
    }
    
    class failRt implements Comparable<failRt>{
        int idx;
        double rate;
        
        public failRt (int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
        
        @Override
        public int compareTo(failRt o) {
            if (Double.compare(o.rate, this.rate) == 0) {
                return this.idx - o.idx;
            }
            return Double.compare(o.rate, this.rate);
        }
    }
}