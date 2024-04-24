package 문제.실버1;

import java.util.*;
public class P2343_블루레이 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 레슨 개수
    int M = sc.nextInt(); // 블루레이 개수
    int[] A = new int[N]; // 레슨별 길이

    int start = 0;
    int end = 0;

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
      // 레슨 최대값을 시작 인덱스로 저장
      if (start < A[i]) start = A[i]; 
      // 모든 레슨의 총합을 종료 인덱스로 저장
      end = end + A[i]; 
    }
    while (start <= end) {
      int middle = (start + end) / 2; // 중앙값
      int sum = 0;
      int count = 0;
      for (int i = 0; i < N; i++) { // 중앙값으로 모든 레슨을 저장할 수 있는지 확인
        if (sum + A[i] > middle) {
          count++;
          sum = 0;
        }
        sum = sum + A[i];
      }
      if (sum != 0) { // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함
        count++;
      }

      if (count > M) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    System.out.println(start);
    sc.close();
  }
}
