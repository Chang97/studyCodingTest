import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] spj1 = {1,2,3,4,5};
        int[] spj2 = {2,1,2,3,2,4,2,5};
        int[] spj3 = {3,3,1,1,2,2,4,4,5,5};
        int idx1 = 0; int idx2 = 0; int idx3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (spj1[idx1] == answers[i]) answer[0]++;
            if (spj2[idx2] == answers[i]) answer[1]++;
            if (spj3[idx3] == answers[i]) answer[2]++;
            idx1++; idx2++; idx3++;
            if (idx1 == spj1.length) idx1 = 0;
            if (idx2 == spj2.length) idx2 = 0;
            if (idx3 == spj3.length) idx3 = 0;
        }
        int Max = -1;
        if(answer[0] > Max) Max = answer[0];
        if(answer[1] > Max) Max = answer[1];
        if(answer[2] > Max) Max = answer[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (Max == answer[i]) list.add(i+1);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}