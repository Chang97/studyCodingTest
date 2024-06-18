package 문제.골드5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * P1916_최소비용구하기
 */
public class P1916_최소비용구하기 {

  static int N, M;
  static ArrayList<Node>[] list; // 인접리스트로 그래프 표현
  static int[] dist; // 최단 거리 배열
  static boolean[] visit; // 사용 노드인지 확인하는 배열
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine()); // 노드 수
    M = Integer.parseInt(br.readLine()); // 에지 수
    list = new ArrayList[N + 1];
    dist = new int[N + 1];
    visit = new boolean[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE); // 거리배열을 큰 수로 초기화
    // 그래프 정보를 저장하는 인접리스트 초기화
    for (int i = 0; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) { // 주어진 그래프의 에지를 인접 리스트 자료구조에 넣기
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      list[start].add(new Node(end, weight));
    }

    st = new StringTokenizer(br.readLine());
    int startIndex = Integer.parseInt(st.nextToken()); // 시작점
    int endIndex = Integer.parseInt(st.nextToken()); // 도착점

    bw.write(dijkstra(startIndex, endIndex) + "\n"); // 다익스트라 알고리즘 수행
    bw.flush();
    bw.close();
    br.close();
  }

  public static int dijkstra (int start, int end) { // 다익스트라 알고리즘
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0)); // 시작점을 오름차순 우선순위 큐에 넣고 시작
    dist[start] = 0;
    while (!pq.isEmpty()) {
      Node nowNode = pq.poll();
      int now = nowNode.targetNode;
      if (!visit[now]) {
        visit[now] = true;
        for (Node n : list[now]) {
          // 선택 노드 + 비용 < 타깃 노드일 때 값을 업데이트
          if (!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value) {
            dist[n.targetNode] = dist[now] + n.value;
            pq.add(new Node(n.targetNode, dist[n.targetNode]));
          }
        }
      }
    }
    return dist[end];
  }

}

class Node implements Comparable<Node> {
  int targetNode;
  int value;

  Node (int targetNode, int value) {
    this.targetNode = targetNode;
    this.value = value;
  }

  @Override
  public int compareTo(Node o) {
    return value = o.value;
  }
}