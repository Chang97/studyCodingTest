import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extendedElements = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            extendedElements[i] = elements[i];
            extendedElements[i + n] = elements[i];
        }
        
        Set<Integer> sums = new HashSet<>();
        
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int length = 1; length <= n; length++) {
                sum += extendedElements[start + length - 1];
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}