package 문제.실버5;

import java.util.*;

public class P1934_최소공배수 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int tmp = b;
      if (a < b) {
        b = a;
        a = tmp;
      }
      int result = a * b / gcd(a, b);
      System.out.println(result);
    }
    sc.close();
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
