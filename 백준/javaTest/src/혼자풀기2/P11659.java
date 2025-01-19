package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P11659 {
  /*
    문제
    수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
    둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
    셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

    출력
    총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

    제한
    1 ≤ N ≤ 100,000
    1 ≤ M ≤ 100,000
    1 ≤ i ≤ j ≤ N
   */
  /*
   * 1. 일단 N,M을 입력 받는다.
   * 2. N개만큼 수를 입력받아 합배열로 저장
   * 3. 구간을 입력받으면 구간합 공식으로 출력 A[i] - A[j] 의 합은 A[j] - A[i-1]
   */
  
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 1
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    // 2
    st = new StringTokenizer(br.readLine());
    long[] arr = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
    }
    // 3
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      System.out.println(arr[e] - arr[s - 1]);
    }

  }
}
