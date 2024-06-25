package 문제.골드3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11437_LCA {
  static ArrayList<Integer>[] tree; // 인접 리스트 자료구조
  static int[] depth; // 노드 깊이 배열
  static int[] parent; // 노드 조상 배열
  static boolean[] visited; // 방문 여부 저장 배열

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 노드의 수

    // tree 인접 리스트의 각 ArrayList 초기화
    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) { // A 인접 리스트에 그래프 데이터 저장하기
      int s = sc.nextInt();
      int e = sc.nextInt();
      tree[s].add(e);
      tree[e].add(s);
    }

    depth = new int[N + 1];
    parent = new int[N + 1];
    visited = new boolean[N + 1];
    // depth와 부모 노드를 BFS를 이용해 구하기
    BFS(1);
    int M = sc.nextInt();
    for (int i = 0; i < M; i++) {
      // 공통 조상을 구할 두 노드
      int a = sc.nextInt();
      int b = sc.nextInt();
      // a와 b의 LCA를 구하는 함수 호출 및 결과값 출력하기
      int LCA = excuteLCA(a, b); 
      System.out.println(LCA);
    }

    sc.close();
  }

  // LCA를 구하는 함수 구현하기
  static int excuteLCA (int a, int b) {
    // a 노드의 depth가 b 노드의 depth 보다 더 작으면 swap
    if (depth[a] < depth[b]) {
      int temp = a;
      a = b;
      b = temp;
    }

    while (depth[a] != depth[b]) { // 두 노드의 depth 맞추기
      a = parent[a];
    }
    while (a != b) { // 같은 조상이 나올 때까지 한 칸씩 올라가기
      a = parent[a];
      b = parent[b];
    }
    return a;
  }

  // BFS 구현 하기
  private static void BFS (int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;
    int level = 1;
    int now_size = 1;
    int count = 0;
    while (!queue.isEmpty()) {
      int now_node = queue.poll();
      for (int next : tree[now_node]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
          parent[next] = now_node; // 부모 노드 저장하기
          depth[next] = level; // 노드 depth 저장하기
        }
      }
      count++;
      // 이번 높이에 해당하는 모든 노드를 방문했을 때
      if (count == now_size) {
        count = 0;
        now_size = queue.size();
        level++;
      }
    }
  }
}
