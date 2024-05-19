import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerPos = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerPos.put(players[i], i);
        }
        
        for (String name :  callings) {
            int idx = playerPos.get(name);
            
            String tmp = players[idx];
            players[idx] = players[idx - 1];
            players[idx - 1] = tmp;
            playerPos.put(players[idx], idx);
            playerPos.put(players[idx - 1], idx - 1);
        }
        return players;
    }
}