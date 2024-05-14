class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                // 타겟 기준으로 문자 하나씩 대조
                String c = String.valueOf(targets[i].charAt(j));
                int min = 101;
                // 키맵 순회하며 최소값 탐색
                for (int k = 0; k < keymap.length; k++) {
                    int idx = keymap[k].indexOf(c);
                    // 키에 존재하며 idx가 최소값인 경우
                    if (idx != -1 && min > idx) min = idx + 1;
                }
                
                if (min == 101) { // 해당 문자가 키에 존재하지않는 경우
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += min;
                }
            }
        }
        
        return answer;
    }
}