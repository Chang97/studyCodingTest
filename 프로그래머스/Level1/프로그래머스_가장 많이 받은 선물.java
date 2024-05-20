import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> giftPoint = new HashMap<>();
        Map<String, Map<String, Integer>> detail = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();
        for (String name : friends) {
            giftPoint.put(name, 0);
            nextMonthGifts.put(name, 0);
            detail.put(name, new HashMap<>());
        }
        
        for (int i = 0; i < gifts.length; i++) {
            String[] tmp = gifts[i].split(" ");
            String from = tmp[0];
            String to = tmp[1];
            giftPoint.put(from, giftPoint.get(from) + 1);
            giftPoint.put(to, giftPoint.get(to) - 1);
            detail.get(from).put(to, detail.get(from).getOrDefault(to, 0) + 1);
        }
        
        for (String from : friends) {
            for (String to : friends) {
                if (!from.equals(to)) {
                    int fromCnt = detail.get(from).getOrDefault(to, 0);
                    int toCnt = detail.get(to).getOrDefault(from, 0);
                    
                    if (fromCnt > toCnt) {
                        nextMonthGifts.put(from, nextMonthGifts.get(from) + 1);
                    } else if (fromCnt == toCnt && giftPoint.get(from) > giftPoint.get(to)){
                        nextMonthGifts.put(from, nextMonthGifts.get(from) + 1);
                    }
                }
            }
        }
        
        for (String name : friends) {
            answer = Math.max(nextMonthGifts.get(name), answer);
        }
        return answer;
    }
}