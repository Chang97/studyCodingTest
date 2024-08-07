package 문제.골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13398_연속합2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    // 오른쪽 방향으로 index를 포함한 최대 연속 합 구하기
    int[] L = new int[N];
    L[0] = A[0];
    int result = L[0];
    for (int i = 1; i < N; i++) {
      L[i] = Math.max(A[i], L[i - 1] + A[i]);
      result = Math.max(result, L[i]);
    }
    // 왼쪽 방향으로 index를 포함한 최대 연속 합 구하기
    int[] R = new int[N];
    R[N - 1] = A[N - 1];
    for (int i = N - 2; i >= 0; i--) {
      R[i] = Math.max(A[i], R[i + 1] + A[i]);
    }
    // L[i - 1] + R[i + 1] 2개의 구간 합 배열을 더하면 i번째 값을 제거한 효과를 얻음
    for (int i = 1; i < N - 1; i++) {
      int temp = L[i - 1] + R[i + 1];  
      result = Math.max(result, temp);
    }
    System.out.println(result);
    br.close();
  }
}
