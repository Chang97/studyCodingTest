class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int[] number) {
        visited = new boolean[number.length];
        DFS(number, 0, 0);
        return answer;
    }
    
    public void DFS (int[] number, int depth, int idx) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < number.length; i++) {
                if (!visited[i]) continue;
                sum += number[i]; 
            }
            if (sum == 0) answer++;
            return;
        }
        
        for (int i = idx; i < number.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            DFS(number, depth + 1, i + 1);
            visited[i] = false;
        }
    }
}