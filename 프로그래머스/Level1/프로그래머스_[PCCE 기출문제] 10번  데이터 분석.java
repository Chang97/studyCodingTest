import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Map<String, Integer>> list = new ArrayList<>();
        int idx = -1;
        if (ext.equals("code")) idx = 0;
        if (ext.equals("date")) idx = 1;
        if (ext.equals("maximum")) idx = 2;
        if (ext.equals("remain")) idx = 3;
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) {
                Map<String, Integer> map = insertRow(data[i]);
                list.add(map);
            }
        }
        
        list.sort(Comparator.comparingInt(map -> map.get(sort_by)));
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).get("code");
            answer[i][1] = list.get(i).get("date");
            answer[i][2] = list.get(i).get("maximum");
            answer[i][3] = list.get(i).get("remain");
        }
        return answer;
    }
    
    public static Map<String, Integer> insertRow (int[] data) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", data[0]);
        map.put("date", data[1]);
        map.put("maximum", data[2]);
        map.put("remain", data[3]);
        return map;
    }
}