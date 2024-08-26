package 혼자풀기;

import java.util.*;

public class P2750 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    int e = N;
    while (e != 0) {
      for (int i = 0; i < e - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
        }
      }
      e--;
    }

    for (int i = 0; i < N; i++) {
      System.out.println(arr[i]);
    }
    sc.close();

   }
}