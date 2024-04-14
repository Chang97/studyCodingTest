package 문제.실버5;

import java.io.*;
import java.util.*;
public class P11004_K번째수 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(A, 0, N - 1, K - 1);
    System.out.println(A[K - 1]);
  }
  public static void quickSort(int[] A, int S, int E, int K) {
    if (S < E) {
      int pivot = partition(A, S, E);
      if (pivot == K) { // K번째 수가 pivot이면 더 이상 구할 필요 없음
        return;
      } else if (K < pivot) { // K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
        quickSort(A, S, pivot - 1, K);
      } else { // K가 pivot 보다 크면 오른쪽 그룹만 정렬 수행하기
        quickSort(A, pivot + 1, E, K);
      }

    }
  }

  public static int partition(int[] A, int S, int E) {
    // S와 E가 붙어 있을경우 swap 하여 E return
    if (S + 1 == E) {
      if (A[S] > A[E]) swap(A, S, E);
      return E;
    }

    // 중앙 값을 1번째 요소로 이동하기
    int M = (S + E) / 2; 
    swap(A, S, M);
    int pivot = A[S];
    int i = S + 1, j = E;
    
    while (i <= j) {
      while (j >= S + 1 && pivot < A[j]) {
        j--;
      }
      while (i <= E && pivot > A[i]) {
        i++;
      }
      if (i <= j) {
        swap (A, i++, j--);
      }
    }
    
    A[S] = A[j];
    A[j] = pivot;
    return j;
  }

  public static void swap (int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
