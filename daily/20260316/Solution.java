import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current_weight = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        int idx = 0;
        while (idx < truck_weights.length) {
            answer++;
            current_weight -= q.poll();
            
            if (current_weight + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]);
                current_weight += truck_weights[idx];
                idx++;
            } else {
                q.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}