package 문제.실버1;

import java.util.*;
public class P1068_리프노드 {
  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int answer = 0;
  static int deleteNode = 0;
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    tree = new ArrayList[N];
    visited = new boolean[N];
    int root = 0;
    for (int i = 0; i < N; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < N; i++) {
      int p = sc.nextInt();
      if (p != -1) {
        tree[i].add(p);
        tree[p].add(i);
      } else {
        root = i;
      }
    }
    deleteNode = sc.nextInt();
    if (deleteNode == root) {
      System.out.println(0);
    } else {
      DFS(root);
      System.out.println(answer);
    }

    sc.close();
  }

  static void DFS(int number) {
    visited[number] = true;
    int cNode = 0;
    for (int i : tree[number]) {
      if (visited[i] == false && i != deleteNode) { // 삭제 노드가 아닐 때도 탐색 중지
        cNode++;
        DFS(i);
      }
    }
    if (cNode == 0) {
      answer++;
    }
  }
}
