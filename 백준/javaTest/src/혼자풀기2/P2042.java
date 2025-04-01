package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P2042 {
    static long[] tree; // 세그먼트 트리 배열열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 변경이 일어나는 수
        int K = Integer.parseInt(st.nextToken()); // 구한 합을 구하는 개수
        int treeHeight = 0; // 트리의 높이
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1; // 리프 노드 시작 인덱스
        tree = new long[treeSize + 1]; // 트리 배열 초기화
        // 리프노드 값 입력 받기
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1); // tree 만들기

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken()); // 질의 유형
            int s = Integer.parseInt(st.nextToken()); // 시작 인덱스
            long e = Long.parseLong(st.nextToken()); // 변경값 또는 종료 인덱스
            if (a == 1) {
                // tree에서 시작 인덱스 값 e로 변경경
                changeVal(leftNodeStartIndex + s, e);
            } else if (a == 2) {
                s = s + leftNodeStartIndex;
                e = e + leftNodeStartIndex;
                // 구간 합 구해서 출력
                System.out.println(getSum(s, (int) e)); 
            }
        }
    }
    // 구간합 구하는 함수
    static long getSum(int s, int e) {
        long partSum = 0;
        while (s <= e) { // 시작 인덱스와 종료 인덱스가 교차될 때 까지
            // 해당 노드의 값을 구간 합에 추가, 시작 인덱스 증가
            if (s % 2 == 1) { 
                partSum = partSum + tree[s];
                s++;
            }

            // 해당 노드의 값을 구간 합에 추가, 종료 인덱스 감소소
            if (e % 2 == 0) {
                partSum = partSum + tree[e];
                e--;
            }

            s = s / 2;
            e = e / 2;
        }
        return partSum;
    }

    // 값 변경 함수수
    static void changeVal(int index, long val) {
        long diff = val - tree[index]; // 현재 노드와 변경된 값의 차이
        while (index > 0) {
            tree[index] = tree[index] + diff; // 시작 인덱스 트리값에 diff 값을 더함함
            index = index / 2;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
