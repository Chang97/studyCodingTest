package 문제.브론즈1;

import java.util.Scanner;

public class P2750_수정렬하기 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int cnt = 1;

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    
    while (cnt < N) {
      for (int i = 0; i < N - cnt; i++) {
        if (arr[i] > arr[i + 1]) {
          int tmp = arr[i + 1];
          arr[i + 1] = arr[i];
          arr[i] = tmp;
        }
      }
      cnt++;
    }

    for (int i = 0; i < N; i++) {
      System.out.println(arr[i]);
    }
  }
}
