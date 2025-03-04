package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break; // 답을 구했으면 종료
            if (arr[i] <= K) {
                result += K / arr[i]; // 몫은 정답에 더함
                K = K % arr[i]; // 나머지를 K로 갱신
            }
        }
        System.out.println(result);
    }
}
