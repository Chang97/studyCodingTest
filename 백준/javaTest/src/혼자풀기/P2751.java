package 혼자풀기;

import java.util.*;
import java.io.*;

public class P2751 {
    static int[] A;
    static int[] tmp;
    private static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
          A[i] = Integer.parseInt(br.readLine());
        }
        
        A = new int[N];
    }
    
    public void bubbleSort(int s, int e) {
        if (e - s < 1) return;
        int m = s + (e - s) / 2;
        // 재귀 함수 형태로 구현
        bubbleSort(s, m);
        bubbleSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) { // 두 그룹을 병합하는 로직
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
            // 선택된 데이터의 index값을 오른쪽으로 한 칸 이동하기
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}