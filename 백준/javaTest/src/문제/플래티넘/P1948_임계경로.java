package 문제.플래티넘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948_임계경로 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 도시 수
    int M = Integer.parseInt(br.readLine()); // 도로 수

    ArrayList<ArrayList<dNode>> A = new ArrayList<>(); // 도시 인접 리스트
    ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>(); // 역방향 인접 리스트

    // 인접 리스트, 역방향 인접리스트 초기화
    for (int i = 0; i <= N; i++) {
      A.add(new ArrayList<>());
      reverseA.add(new ArrayList<>());
    }

    int[] indegree = new int[N + 1]; // 진입 차수 배열
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      A.get(S).add(new dNode(E, V));
      reverseA.get(E).add(new dNode(S, V)); // 역방향 에지 정보 저장
      indegree[E]++; // 진입 차수 배열 초기화
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int startDosi = Integer.parseInt(st.nextToken());
    int endDosi = Integer.parseInt(st.nextToken());

    // 위상정렬
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(startDosi);
    int[] result = new int[N + 1];
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (dNode next : A.get(now)) {
        // 타깃 노드 진입 차수 배열 --
        indegree[next.targetNode]--;
        // result = 타깃 노드의 현재 경로 값과 현재 노드의 경로값 + 도로 시간값 중 큰 값으로 저장
        result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
        if (indegree[next.targetNode] == 0) { // 진입 차수가 0이면 queue에 추가
          queue.offer(next.targetNode);
        }
      }
    }

    // 위상 정렬 reverse
    int resultCount = 0; // 1분도 쉬지 않고 달려야 하는 도로의 수
    boolean visited[] = new boolean[N + 1]; // 각 도시 방문 유무 저장용
    queue = new LinkedList<>();
    queue.offer(endDosi);
    visited[endDosi] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (dNode next : reverseA.get(now)) {
        // 1분도 쉬지 않는 도로 체크하기
        // 타깃 노드의 result값 + 도로를 걸리는 데 지나는 시간(에지) == 현재 노드의 result값
        if (result[next.targetNode] + next.value == result[now]) {
          resultCount++;
          // 중복 카운트 방지를 위해 이미 방문한 적 있는 노드 제외
          if (visited[next.targetNode] == false) {
            visited[next.targetNode] = true;
            queue.offer(next.targetNode);
          }
        }
      }
    }
    System.out.println(result[endDosi]);
    System.out.println(resultCount);

  } 
}

class dNode {
  int targetNode;
  int value;
  dNode (int targetNode, int value) {
    this.targetNode = targetNode;
    this.value = value;
  }
}
