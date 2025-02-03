package 혼자풀기2;

import java.io.*;
public class P2750 {
  /*
    문제
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

    출력
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
   */
  /*
   * 풀이
   * Arrays.sort() 사용해도 되지만 버블정렬을 활용해서 풀어볼 예정
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int e = N - 1;
    while (0 < e) {
      for (int i = 0; i < e; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
        }
      }
      e--;
    }

    for (int i = 0; i < N; i++) {
      System.out.println(arr[i]);
    }

  }
}