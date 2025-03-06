package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열의 크기 N과 질의 개수 M을 입력 받음.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N + 1];
        // 구간합 배열 생성
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        // 입력 받은 범위에 맞게 구간합 공식을 이용하여 답 출력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(arr[e] - arr[s - 1]);
        }
    }
}
