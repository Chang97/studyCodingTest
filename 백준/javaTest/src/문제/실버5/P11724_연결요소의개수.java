package 문제.실버5;

import java.io.*;
import java.util.*;
public class P11724_연결요소의개수 {
  // 인접 리스트
  static ArrayList<Integer>[] A;
  // 방문 배열
  static boolean visited[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // node 개수 입력
    int n = Integer.parseInt(st.nextToken());
    // edge 개수 입력
    int m = Integer.parseInt(st.nextToken());

    // 노드 개수만큼 공간 확보 (노드는 1~n까지 수이기에 한칸 늘려서 인덱스 1부터 사용)
    A = new ArrayList[n + 1];
    // 노드 방문 여부 판별하는 배열
    visited = new boolean[n + 1];


    for (int i = 1; i <= n; i++) {
      //ArrayList 배열 초기화
      A[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      // 양 끝점 입력
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      // 양방향 그래프 이기에 양쪽에 add 시킴
      A[s].add(e);
      A[e].add(s);
    }
    // DFS 순회 횟수 카운트 변수
    int count = 0;
    for (int i = 1; i <= n; i++) {
      // 방분하지 않은 노드인 경우 DFS 호출
      if (!visited[i]) {
        count++;
        DFS(i);
      }
    }
    System.out.println(count);
  }
  static void DFS(int v) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    // 그래프 순회
    for (int i : A[v]) {
      if (visited[i] == false) {
        DFS(i);
      }
    }
  }
}
