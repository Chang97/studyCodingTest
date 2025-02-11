package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P13023 {
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

    // 연결리스트 초기화
    for (int i = 0; i < N; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      arr[u].add(v);
      arr[v].add(u);
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

  static void DFS (int v, int count) {
    if (count == 5 || arrive) {
      arrive = true;
      return;
    }
    
    visited[v] = true;
    for (int n : arr[v]) {
      if (!visited[n]) {
        DFS(n, count + 1);
      }
    }
    visited[v] = false;
  }
}