package 문제.골드3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_줄세우기 {
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 학생 수
    int M = sc.nextInt(); // 비교 횟수
    ArrayList<ArrayList<Integer>> A = new ArrayList<>(); // 데이터 저장 인접 리스트

    // 학생 수 만큼 인접 리스트 초기화하기
    for (int i = 0; i <= N; i++) {
      A.add(new ArrayList<>());
    }

    int[] indegree = new int[N + 1]; // 진입 차수 배열
    for (int i = 0; i < M; i++) {
      int S = sc.nextInt();
      int E = sc.nextInt();
      A.get(S).add(E);
      indegree[E]++; // 진입 차수 데이터 저장
    }

    Queue<Integer> queue = new LinkedList<>(); // 위상 정렬 수행
    for (int i = 1; i <= N; i++) {
      // 진입 차수 배열의 값이 0인 학생(노드)을 큐에 삽입하기
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int now = queue.poll();
      System.out.print(now + " ");
      for (int next : A.get(now)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          queue.offer(next);
        }
      }
    }

    sc.close();
  }
}
