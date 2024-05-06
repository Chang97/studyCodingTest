package 문제.골드2;

import java.util.*;
import java.io.*;

public class P1033_칵테일 {
  static ArrayList<cNode>[] A;
  static long lcm;
  static boolean[] visited;
  static long[] D;

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(st.nextToken());

    A = new ArrayList[N];
    visited = new boolean[N];
    D = new long[N];
    lcm = 1;
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<cNode>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      A[a].add(new cNode(b, p, q));
      A[b].add(new cNode(a, q, p));
      lcm = lcm * (p * q / gcd(p, q)); // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
    }
    D[0] = lcm;
    DFS(0);
    long mgcd = D[0];
    for (int i = 1; i < N; i ++) {
      mgcd = gcd(mgcd, D[i]);
    }
    for (int i = 0; i < N; i++) {
      bw.write(D[i] / mgcd + " ");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  public static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  public static void DFS(int Node) {
    visited[Node] = true;
    for (cNode i : A[Node]) {
      int next = i.b;
      if (!visited[next]) {
        D[next] = D[Node] * i.q / i.p;
        DFS(next);
      }
    }
  }

}
class cNode {
  int b;
  int p;
  int q;

  public cNode (int b, int p, int q) {
    super();
    this.b = b;
    this.p = p;
    this.q = q;
  }
}
