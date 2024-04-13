package 문제.실버4;

import java.util.*;
public class P2164_카드 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> queue = new LinkedList<>();

    int N = sc.nextInt();
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    while (queue.size() > 1) {
      queue.poll();
      queue.add(queue.poll());
    }

    System.out.println(queue.poll());
  }
  
}
