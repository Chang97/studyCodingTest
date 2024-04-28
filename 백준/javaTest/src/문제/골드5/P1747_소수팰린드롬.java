package 문제.골드5;

import java.util.*;
public class P1747_소수팰린드롬 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[10000001]; // N의 범위까지 소수 구하기
    for (int i = 2; i < A.length; i++) {
      A[i] = i;
    }

    for (int i = 2; i < Math.sqrt(A.length); i++) {
      if (A[i] == 0) {
        continue;
      }
      for (int j = i + i; j < A.length; j = j + i) {
        A[j] = 0;
      }
    }
    int i = N;

    while (true) {
      if (A[i] != 0) {
        int result = A[i];
        if (isPalindrome(result)) {
          System.out.println(result);
          break;
        }
      }
      i++;
    }
    sc.close();
  }
  // 펠린드롬 판별 함수
  private static boolean isPalindrome(int target) {
    char[] temp = String.valueOf(target).toCharArray();
    int s = 0;
    int e = temp.length - 1;
    while (s < e) {
      if (temp[s] != temp[e]) {
        return false;
      }
      s++;
      e--;
    }
    return true;
  }
}
