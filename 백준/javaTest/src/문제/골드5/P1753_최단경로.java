package 문제.골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로 {
  public static int V, E, K;
  public static int distance[]; // 최단 거리 저장
  public static boolean visited[]; // 방문여부 저장
  public static ArrayList<Edge> list[]; // 그래프 정보 저장
  public static PriorityQueue<Edge> q = new PriorityQueue<>(); //

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken()); // 노드 개수
    E = Integer.parseInt(st.nextToken()); // 에지 개수
    K = Integer.parseInt(br.readLine()); // 출발 노드
    distance = new int[V + 1];
    visited = new boolean[V + 1];
    list = new ArrayList[V + 1];
    // 인접 리스트 초기화
    for (int i = 1; i <= V; i++) {
      list[i] = new ArrayList<>();
    }
    // 거리 정보 큰 수로 초기화하기
    for (int i = 0; i <= V; i++) {
      distance[i] = Integer.MAX_VALUE;
    }

    // 가중치가 있는 인접리스트 초기화
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      list[u].add(new Edge(v, w));
    }

    q.add(new Edge(K, 0)); // K를 시작점으로 설정
    distance[K] = 0;

    while (!q.isEmpty()) {
      Edge current = q.poll();
      int c_v = current.vertex;
      if (visited[c_v]) continue; // 이미 방문한 적이 있는 노드는 다시 큐에 넣지 않음
      visited[c_v] = true;

      for (int i = 0; i < list[c_v].size(); i++) {
        Edge tmp = list[c_v].get(i);
        int next = tmp.vertex;
        int value = tmp.value;
        // 타깃 노드 방문 전 && 현재 선택 노드 최단 거리 + 비용 < 타깃 노드의 최단 거리
        if (distance[next] > distance[c_v] + value) { // 최소거리로 업데이트
          distance[next] = value + distance[c_v];
          q.add(new Edge(next, distance[next]));
        } 
      }
    }
    for (int i = 1; i <= V; i++) { // 거리 배열 출력
      if (visited[i]) {
        System.out.println(distance[i]);
      } else {
        System.out.println("INF");
      }
    }

  }
}

class Edge implements Comparable<Edge> {
  int vertex, value;

  Edge (int vertex, int value) {
    this.vertex = vertex;
    this.value = value;
  }

  public int compareTo(Edge e) {
    if (this.value > e.value) return 1;
    else return -1;
  }
}
