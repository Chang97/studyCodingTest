package 문제.실버1;

import java.util.*;

public class P1991_트리순회 {
  static int[][] tree;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    tree = new int[26][2]; // 0 -> 왼쪽 자식 노드(1), 1 -> 오른쪽 자식 노드(2)
    for (int i = 0; i < n; i++) {
      String[] temp = sc.nextLine().split(" ");
      int node = temp[0].charAt(0) - 'A';
      char left = temp[1].charAt(0);
      char right = temp[2].charAt(0);
      // 자식 노드가 없을 때 -1을 저장
      if (left == '.') {
        tree[node][0] = -1;
      } else {
        tree[node][0] = left - 'A';
      }
      if (right == '.') {
        tree[node][1] = -1;
      } else {
        tree[node][1] = right - 'A';
      }
    }

    preOrder(0);
    System.out.println();
    inOrder(0);
    System.out.println();
    postOrder(0);

    sc.close();
  }

  public static void preOrder(int now) {
    if (now == -1) return;
    System.out.print((char) (now + 'A')); // 1.현재노드
    preOrder(tree[now][0]); // 2.왼쪽 탐색
    preOrder(tree[now][1]); // 3. 오른쪽 탐색
  }

  public static void inOrder(int now) {
    if (now == -1) return;
    inOrder(tree[now][0]); // 1.왼쪽 탐색
    System.out.print((char) (now + 'A')); // 2.현재노드
    inOrder(tree[now][1]); // 3. 오른쪽 탐색
  }

  public static void postOrder(int now) {
    if (now == -1) return;
    postOrder(tree[now][0]); // 1.왼쪽 탐색
    postOrder(tree[now][1]); // 2. 오른쪽 탐색
    System.out.print((char) (now + 'A')); // 3.현재노드
  }
}
