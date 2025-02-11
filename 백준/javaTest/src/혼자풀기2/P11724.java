package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P11724 {
  /*
    문제
    방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
    (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
    (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

    출력
    첫째 줄에 연결 요소의 개수를 출력한다.
   */
  /*
   * DFS(깊이우선 탐색)를 이용해서 풀이 
   * 1. 필요한 변수 세팅 (연결리스트, 방문여부 판별 배열)
   * 2. 시작점을 지정한 후 탐색 시작
   * 3. 끝까지 이동했으면 다음 시작점 찾기 (미방문)
   * 4. 모두 다 방문 끝났으면 끝
   * */
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    List<Integer>[] arr = new ArrayList[N + 1];
    boolean[] visited = new boolean[N + 1];
    int result = 0;

    // 연결리스트 초기화
    for (int i = 1; i <= N; i++) { 
      arr[i] = new ArrayList<>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      arr[u].add(v);
      arr[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        result++;
        DFS(i, visited, arr);
      }
    }

    System.out.println(result);

  }

  static void DFS(int v, boolean[] visited, List<Integer>[] arr) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    for (int i = 0; i < arr[v].size(); i++) {
      if (!visited[arr[v].get(i)]) {
        DFS(arr[v].get(i), visited, arr);
      }
    }
  }
}