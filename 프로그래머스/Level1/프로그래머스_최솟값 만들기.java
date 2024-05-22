import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int s = 0;
        int e = A.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);
        
        while (s <= A.length - 1 && e >= 0) {
            answer += A[s++] * B[e--];
        }

        return answer;
    }
}