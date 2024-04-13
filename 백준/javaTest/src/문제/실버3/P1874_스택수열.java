package 문제.실버3;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int su = 1;
    boolean result = true;
    for (int num : A) {
      if (su <= num) {
        while (su <= num) {
          stack.push(su++);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      } else {
        int tmpNum = stack.pop();

        if (tmpNum > num) {
          System.out.println("NO");
          result = false;
          break;
        } else {
          sb.append("-\n");
        }
      }
    }
    if (result) System.out.println(sb.toString());
  }
}
