import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Set<Integer> set = new HashSet<>();
        
        set.add(a);set.add(b);set.add(c);set.add(d);
        
        if (set.size() == 1) {
            return 1111 * a;
        }
        
        if (set.size() == 4) {
            List<Integer> list = Arrays.asList(a, b, c, d);
            return Collections.min(list);
        }
        
        int[] arr = {a, b, c, d};
        Map<String, Integer> map = new HashMap<>();
        int gubun = 0;
        for (Integer item : set) {
            int dupCnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (item == arr[i]) {
                    dupCnt++;
                }
            }
            if (dupCnt == 3) {
                map.put("p", item);
                gubun = 3;
            }
            if (dupCnt == 2) {
                if (!map.containsKey("p")) map.put("p", item);
                else map.put("q", item);
                gubun = 2;
            }
            if (dupCnt == 1) {
                if (!map.containsKey("q")) map.put("q", item);
                else map.put("r", item);
            }
        }
        
        
        if (map.containsKey("r")) {
            return map.get("q") * map.get("r");
        } else if (gubun == 2) {
            return (map.get("p") + map.get("q")) * Math.abs(map.get("p") - map.get("q"));
        } else if (gubun == 3) {
            return (int) Math.pow((10 * map.get("p") + map.get("q")), 2);
        }
            
        return 0;
    }
    
}