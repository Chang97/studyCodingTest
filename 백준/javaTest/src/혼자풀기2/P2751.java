package 혼자풀기2;

import java.io.*;

public class P2751 {
  static int[] sorted;
  /*
    문제
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

    출력
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
   */
  /*
   * 풀이
   * 연습을위해 병합정렬을 사용하여 풀어보자
   * 
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    sorted = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    mergeSort(arr, 0, N - 1);
    for (int i = 0; i < N; i++) {
      System.out.println(arr[i]);
    }

  }

  static void mergeSort(int[] arr, int start, int end) {
    if (start == end) return; // 더이상 못 쪼개면 stop
    int mid = (start + end) / 2; 

    mergeSort(arr, start, mid); // 좌 
    mergeSort(arr, mid + 1, end); // 우

    merge(arr, start, mid, end); // 정렬
  }

  static void merge(int[] arr, int start, int mid, int end) {
    int l = start;
    int r = mid + 1;
    int idx = start;

    while (l <= mid && r <= end) {
      if (arr[l] < arr[r]) {
        sorted[idx++] = arr[l++];
      } else {
        sorted[idx++] = arr[r++];
      }
    }

    if (l > mid) {
      while (r <= end) {
        sorted[idx++] = arr[r++];
      }
    } else {
      while (l <= mid) {
        sorted[idx++] = arr[l++];
      }
    }

    for (int i = start; i <= end; i++) {
      arr[i] = sorted[i];
    }
  }
}
