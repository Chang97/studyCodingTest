class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] wall = new boolean[n + 1];
        int answer = 0;
        for (int i = 0; i < section.length; i++) {
            wall[section[i]] = true;
        }
        
        for (int i = 0; i < section.length; i++) {
            if (wall[section[i]] == false) continue;
            for (int j = section[i]; j < section[i] + m; j++) {
                if (j == wall.length) break;
                wall[j] = false;
            }
            answer++;
        }
        return answer;
    }
}