package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P1167 {
  /*
    문제
    트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 
    트리의 지름을 구하는 프로그램을 작성하시오.

    입력
    트리가 입력으로 주어진다. 
    먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)
    둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 
    정점 번호는 1부터 V까지 매겨져 있다.

    먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 
    다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 
    정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 
    주어지는 거리는 모두 10,000 이하의 자연수이다.

    출력
    첫째 줄에 트리의 지름을 출력한다.
   */
  /*
   * 풀이
   * 가장 먼 거리를 찾아야함
   * 가중치가 있기 때문에 클래스 하나 생성해서 진행 (Node)
   * 일반적인 BFS처럼 탐색 후 거리가 제일 먼곳을 찾음
   * 거리가 제일 먼곳에서 다시 탐색하면 최장거리임
   * 
   */
  static boolean[] visited;
  static List<Node>[] arr;
  static int[] distance;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int V = Integer.parseInt(br.readLine());

    arr = new ArrayList[V + 1];
    visited = new boolean[V + 1];
    distance = new int[V + 1];

    for (int i = 1; i <= V; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int idx = Integer.parseInt(st.nextToken());
      
      while (true) {
        int n = Integer.parseInt(st.nextToken());
        if (n == -1) break;
        int w = Integer.parseInt(st.nextToken());
        arr[idx].add(new Node(n, w));
        arr[n].add(new Node(idx, w));
      }
    }

    BFS(1);

    int maxIdx = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 1; i <= V; i++) {
      if (distance[i] > max) {
        max = distance[i];
        maxIdx = i;
      }
    }

    // 초기화
    visited = new boolean[V + 1];
    distance = new int[V + 1];
    BFS(maxIdx);

    maxIdx = 0;
    max = Integer.MIN_VALUE;

    for (int i = 1; i <= V; i++) {
      if (distance[i] > max) {
        max = distance[i];
        maxIdx = i;
      }
    }

    System.out.println(max);

  }

  static void BFS(int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = true;
    while (!queue.isEmpty()) {
      int index = queue.poll();
      for (Node node : arr[index]) {
        if (visited[node.n]) continue;
        queue.add(node.n);
        visited[node.n] = true;
        distance[node.n] = distance[index] + node.w;
      }
    }
  }

  static class Node {
    int n;
    int w;

    Node (int n, int w) {
      this.n = n;
      this.w = w;
    }
  }
}
