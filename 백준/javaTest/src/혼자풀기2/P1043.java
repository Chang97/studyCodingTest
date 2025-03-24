package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P1043 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] party = new int[M + 1][51];
        
        
        // 사람 배열 초기화
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        
        // 진실을 아는 사람 배열 입력받기
        st = new StringTokenizer(br.readLine());
        int trueLen = Integer.parseInt(st.nextToken());
        int[] trueArr = new int[trueLen];
        for (int i = 0; i < trueLen; i++) {
            trueArr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 파티 정보 입력받기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= len; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (trueLen == 0) { // 진실을 아는 사람 수가 0이면 파티수를 출력하고 종료
            System.out.println(M);
            return;
        }
        // 진실을 아는 사람 유니온
        for (int i = 1; i < trueLen; i++) {
            union(arr, trueArr[i - 1], trueArr[i]);
        }
        
        // 각 파티별 사람들 유니온 처리
        for (int i = 1; i <= M; i++) {
            for (int j = 2; j <= 51; j++) {
                if (party[i][j] == 0) break;
                union(arr, party[i][j - 1], party[i][j]);
            }
        }
        
        int result = 0;
        int trueGroupIdx = find(arr, arr[trueArr[0]]);
        // 진실 집합에 포함되지 않는 파티 찾기
        for (int i = 1; i <= M; i++) {
            boolean flag = false;
            for (int j = 1; j <= 51; j++) {
                if (party[i][j] == 0) break;
                if (trueGroupIdx == find(arr, arr[party[i][j]])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result++;
        }
        
        System.out.println(result);
    }
    
    static void union (int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        
        if (a != b) {
            arr[b] = a;
        }
    }
    
    static int find (int[] arr, int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return find (arr, arr[a]);
        }
    }
}
