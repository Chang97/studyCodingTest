package 문제.실버3;

import java.util.*;
public class P11047_동전개수최솟값 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    int cnt = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (A[i] > K) continue;
      cnt += K / A[i];
      K = K % A[i];
    }
    System.out.println(cnt);
    sc.close();
  }
}
