package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1517 {
  static long[] sorted;
  static long result;
  public static void main(String[] args) throws IOException {
    /*
      문제
      N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.

      버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다. 예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.

      입력
      첫째 줄에 N(1 ≤ N ≤ 500,000)이 주어진다. 다음 줄에는 N개의 정수로 A[1], A[2], …, A[N]이 주어진다. 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000의 범위에 들어있다.

      출력
      첫째 줄에 Swap 횟수를 출력한다
     * 
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N];
    sorted = new long[N];
    result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());


    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    mergeSort(arr, 0, N - 1);

    System.out.println(result);

  }

  static void mergeSort(long[] arr, int start, int end) {
    if (start >= end) return;
    int mid = (start + end) / 2;

    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);

    merge(arr, start, mid, end);
  }

  static void merge(long[] arr, int start, int mid, int end) {
    int l = start;
    int r = mid + 1;
    int idx = start;

    while (l <= mid && r <= end) {
      if (arr[l] <= arr[r]) {
        sorted[idx++] = arr[l++];
      } else {
        result = result + r - idx;
        sorted[idx++] = arr[r++];
      }
    }

    while (l <= mid) {
      sorted[idx++] = arr[l++];
    }

    while (r <= end) {
      sorted[idx++] = arr[r++];
    }

    for (int i = start; i <= end; i++) {
      arr[i] = sorted[i];
    }
  }
  
}
