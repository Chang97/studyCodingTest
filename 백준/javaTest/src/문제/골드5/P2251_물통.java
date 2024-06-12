package 문제.골드5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2251_물통 {
  // 6가지 이동 케이스를 표현하기 위한 배열
  static int[] Sender = { 0, 0, 1, 1, 2, 2};
  static int[] Receiver = { 1, 2, 0, 2, 0, 1};
  static boolean visitied[][]; // A, B의 무게만 있으면 C의 무게가 고정되므로 2개만 체크
  static boolean answer[]; // 정답 배열
  static int now[]; // A, B, C의 값을 저장하는 배열

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    now = new int[3];
    now[0] = sc.nextInt();
    now[1] = sc.nextInt();
    now[2] = sc.nextInt();
    visitied = new boolean[201][201];
    answer = new boolean[201];
    BFS();
    for (int i = 0; i < answer.length; i++) {
      if (answer[i]) System.out.print(i + " ");
    }
  }

  public static void BFS() {
    Queue<AB> queue = new LinkedList<>();
    // 큐 자료구조에 출발 노드 더하기 -> A 와 B가 0인 상태이므로 0, 0 노드에서 시작
    queue.add(new AB(0, 0));
    visitied[0][0] = true;
    answer[now[2]] = true;

    while (!queue.isEmpty()) {
      AB p = queue.poll();
      int A = p.A;
      int B = p.B;
      int C = now[2] - A - B; // C는 전체 물의 양에서 A와 B를 뺀 것

      // 6가지 케이스 반복
      for (int k = 0; k < 6; k++) { // A -> B, A -> C, B -> A, B -> C, C -> A, C -> B
        int[] next = { A, B, C};
        // 받는 물통에 보내려는 물통의 값 더하기
        next[Receiver[k]] += next[Sender[k]];
        // 보내려는 물통 값을 0 으로 업데이트
        next[Sender[k]] = 0;

        if (next[Receiver[k]] > now[Receiver[k]]) { // 물이 넘칠 때
          // 초과하는 만큼 다시 이전 물통에 넣어 줌
          next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
          next[Receiver[k]] = now[Receiver[k]]; // 대상 물통은 최대로 채워줌
        }
        
        if (!visitied[next[0]][next[1]]) { // A와 B의 물의 양을 이용해 방문 배열 체크
          visitied[next[0]][next[1]] = true;
          queue.add(new AB(next[0], next[1]));
          if (next[0] == 0) {
            answer[next[2]] = true;
          }

        }
      }
    }
  }
}

// AB 클래스 선언 -> A와 B의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용
class AB {
  int A;
  int B;
  public AB(int A, int B) {
    this.A = A;
    this.B = B;
  }
}
