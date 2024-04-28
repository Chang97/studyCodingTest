package 문제.실버1;

import java.util.*;

public class P1456_거의소수 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    long Min = sc.nextLong();
    long Max = sc.nextLong();
    // 10의 14승의 제곱근인 10의 7승까지 반복
    long[] A = new long[10000001];

    // 배열 초기화
    for (int i = 0; i < A.length; i++) {
      A[i] = i;
    }

    // 소수 구하기
    for (int i = 2; i <= Math.sqrt(A.length); i++) {
      if (A[i] == 0) continue;
      for (int j = i + i; j < A.length; j = j + i) {
        A[j] = 0;
      }
    }

    int cnt = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] != 0) { // 소수인 경우
        long temp = A[i]; // 현재 소수
        // 현재 소수의 제곱근이 Max보다 작을 때를 기준으로 하지만
        // 곱셈이 long의 범위를 넘어갈 수 있어 이항 정리로 처리 
        while ((double)A[i] <= (double)Max / (double)temp) {
          if ((double)A[i] >= (double)Min / (double)temp) {
            cnt++;
          }
          temp = temp * A[i];
        }
      }
    }
    System.out.println(cnt);
    sc.close();
  }
}
