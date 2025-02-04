package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11004 {
  static int K;
  /*
    문제
    수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

    둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

    출력
    A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
   */
  /*
   * 풀이
   * 일반적인 정렬 문제이나 연습을 위해 퀵 정렬을 사용한다.
   * 재귀 함수를 이용하여 구현하며 최종 high와 swap 후 
   * high index와 K를 비교하여 high < K 이면 우측 기준으로 퀵정렬
   * high index와 K를 비교하여 high > K 이면 좌측 기준으로 퀵정렬
   * 동일하면 해당 값 출력
   * 
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken()) - 1;
    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(arr, 0, N - 1);
    System.out.println(arr[K]);
    

  }

  static void quickSort(int[] arr, int left, int right) {
    
    if (left < right) {
      int pivot = partition(arr, left, right);
      if (pivot == K) {
        return;
      } else if (K < pivot) {
        quickSort(arr, left, pivot - 1);
      } else {
        quickSort(arr, pivot + 1, right);
      }
    }
    
  }

  static int partition(int[] arr, int left, int right) {
    int low = left + 1;
    int high = right;
    if (low == high) {
      if (arr[left] > arr[right]) swap(arr, left, right);
      return right;
    }
    int M = (left + right) / 2;
    swap(arr, left, M);
    
    while (low <= high) {
      while (low >= left + 1 && arr[left] > arr[low]) {
        low++;
      }
      while (high <= right && arr[left] < arr[high]) {
        high--;
      }
      if (low <= high) {
        swap(arr, low++, high--);
      }
    }
    
    swap(arr, left, high);
    
    return high;
  }

  static void swap(int[] arr, int s, int t) {
    int temp = arr[s];
    arr[s] = arr[t];
    arr[t] = temp;
  }
  
}
