package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P1260 {
  /*
    문제
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
    정점 번호는 1번부터 N번까지이다.

    입력
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
    어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
    입력으로 주어지는 간선은 양방향이다.

    출력
    첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
   */
  /*
   * 문제 그대로 DFS와 BFS를 사용해서 구현
   * 간선이 여러개인경우 숫자가 적은쪽을 우선으로 간다는 조건이 있으니
   * 정렬 한번 하고 난 후 진행
   */
  static List<Integer>[] arr;
  static boolean[] visited;
  static StringBuffer sb;
  static Queue<Integer> queue = new LinkedList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuffer();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    arr = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      arr[s].add(e);
      arr[e].add(s);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(arr[i]);
    }

    DFS(V);
    System.out.println(sb.toString());

    // 초기화
    sb = new StringBuffer();
    visited = new boolean[N + 1];
    BFS(V);
    System.out.println(sb.toString());
    
  }

  static void DFS(int v) {
    if (visited[v]) return;

    visited[v] = true;
    sb.append(v + " ");
    for (int i : arr[v]) {
      if (visited[i]) continue;
      DFS(i);
    }
  }

  static void BFS(int v) {
    if (visited[v]) return;

    visited[v] = true;
    sb.append(v + " ");
    queue.add(v);

    while (!queue.isEmpty()) {
      int index = queue.poll();

      for (int i : arr[index]) {
        if (visited[i]) continue;

        sb.append(i + " ");
        queue.add(i);
        visited[i] = true;
      }
    }
  }
}
