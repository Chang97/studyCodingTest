package 혼자풀기2;

import java.io.*;

public class P10989 {
  static int[] arr;
  /*
    문제
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 
    둘째 줄부터 N개의 줄에는 수가 주어진다. 
    이 수는 10,000보다 작거나 같은 자연수이다.

    출력
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
   */
  /*
   * 풀이
   * nlogn 정렬을 이용하면 안됨
   * 각 요소의 max값이 5자리이니 O(kn)인 기수정렬을 이용
   * 우선순위 큐를 사용하여 구현할 수 있으나 이는 속도저하요소가 있기에 계수정렬방식을 사용
   * 
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    br.close();

    // 요소 max : 10000 -> 5자리
    radixSort(arr, 5);

    for (int i = 0; i < N; i++) {
      bw.write(arr[i] + "\n");
    }

    bw.flush();
    bw.close();

  }

  static void radixSort(int[] arr, int max) {
    int[] output = new int[arr.length];
    int jarisu = 1;
    int count = 0;
    while (count != max) {
      int[] bucket = new int[10];
      for (int i = 0; i < arr.length; i++) { // 각자리수 별 index에 ++
        bucket[(arr[i] / jarisu) % 10]++;
      }

      for (int i = 1; i < 10; i++) { // 각 자리수가 들고 있는 index 누적합으로
        bucket[i] += bucket[i - 1];
      }

      for (int i = arr.length - 1; i >= 0; i--) {
        // output에 자리수별로 위치해야할 index에 넣고 bucket index는 --
        // 같은 숫자가 여러 개 있으면, 원래 순서를 유지해야 하기 때문에 뒤에서 부터 진행
        output[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i];
        bucket[(arr[i] / jarisu) % 10]--;
      }

      for (int i = 0; i < arr.length; i++) { // 정렬된 값 복사
        arr[i] = output[i];
      }
      jarisu = jarisu * 10;
      count++;
    }
  }
}
