package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P10986 {
  /*
    문제
    수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.

    즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

    입력
    첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)

    둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)

    출력
    첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
   */
  /*
   * 풀이 과정
   * 1. N과 M을 입력받는다.
   * 2. N개수 만큼 숫자를 입력받아 구분합 배열 생성
   * 3. 슬라이딩 윈도우 너낌으로 사악 순회해서 구하면 되지 않을까?
   * 시간초과 ...
   * 
   * 재시도
   * 3. 같은 나머지의 인덱스를 카운트하는 배열 C가 필요함 int[N]
   * 4. 나머지가 같은 인덱스중 2개를 뽑는 경우의 수를 더한다. 조합 경우의수 식 : (C[i] * (C[i] - 1) / 2) 
   * 20250119
   * 해설을 보고 위와같이 정리했으나 왜 위 과정으로 정답이 도출되는지 모르겠음...
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 1
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 2
    long[] arr = new long[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      // 나머지를 넣는다.
      arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
    }

    long count = 0;
    // 3
    long[] C = new long[M];
    for (int i = 1; i <= N; i++) {
      int remainder = (int)(arr[i] % M);
      if (remainder == 0) count++;
      C[remainder]++;
    }

    for (int i = 0; i < M; i++) {
      if (C[i] > 1) {
        count = count + (C[i] * (C[i] - 1) / 2);
      }
    }
    System.out.println(count);
  }
}
