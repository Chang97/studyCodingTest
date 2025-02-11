package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P13023 {
  /*
   *  문제
      BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

      오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

      A는 B와 친구다.
      B는 C와 친구다.
      C는 D와 친구다.
      D는 E와 친구다.
      위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

      입력
      첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

      둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. 
      (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

      출력
      문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
   */
  /*
   * 풀이
   * DFS를 이용하여 풀이
   * 1. depth가 5인 연결이 존재하는지 판별하는 문제이다.
   * 2. 시작점에 따라서 마지막 depth가 다르기 때문에 N까지의 수들을 순회하며 찾는다.
   * 3. dpeth가 5인경우 1출력하고 종료
   * 4. 그게 아닌 경우에는 연결된 노드로 계속 파고들어감
   * 
   */
  static List<Integer>[] arr;
  static boolean[] visited;
  static boolean arrive = false;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N];
    visited = new boolean[N];

    // 리스트 초기화
    for (int i = 0; i < N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a].add(b);
      arr[b].add(a);
    }

    for (int i = 0; i < N; i++) {
      DFS(i, 1);
      if (arrive) break;
    }

    if (arrive) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
    
  }

  static void DFS(int num, int depth) {
    if (depth == 5) {
      arrive = true;
      return;
    }
    visited[num] = true;
    for (int i : arr[num]) {
      if (visited[i]) continue;
      DFS(i, depth + 1);
    }
    visited[num] = false;
  }
}