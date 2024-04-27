package 문제.골드4;

import java.util.*;
public class P1715_카드정렬하기 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      pq.add(sc.nextInt());
    }
    int data1 = 0;
    int data2 = 0;
    int sum = 0;
    while (pq.size() >= 2) {
      data1 = pq.remove();
      data2 = pq.remove();
      sum += data1 + data2;
      pq.add(sum);
    }
    System.out.println(sum);
    sc.close();
  }
}
