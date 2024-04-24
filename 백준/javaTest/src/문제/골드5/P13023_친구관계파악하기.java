package 문제.골드5;

import java.util.*;
public class P13023_친구관계파악하기 {
  static boolean visited[];
  static ArrayList<Integer>[] A;
  static boolean arrive;
  @SuppressWarnings("unchecked")
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 노드 개수
    int M = sc.nextInt(); // 에지 개수
    arrive = false;
    A = new ArrayList[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      int S = sc.nextInt();
      int E = sc.nextInt();
      A[S].add(E);
      A[E].add(S);
    }

    for (int i = 0; i < N; i++) {
      DFS(i, 1); // depth 1 부터 시작
      if (arrive) break;
    }
    if (arrive) System.out.println("1");
    else System.out.println("0"); // 5의 깊이가 없다면 0 출력
    sc.close();
  }

  public static void DFS (int now, int depth) {
    if (depth == 5 || arrive) {
      arrive = true;
      return;
    }
    visited[now] = true;
    for (int i : A[now]) {
      if (!visited[i]) {
        DFS(i, depth + 1); // depth 늘려가며 탐색
      }
    }
    visited[now] = false;
  }

  
}