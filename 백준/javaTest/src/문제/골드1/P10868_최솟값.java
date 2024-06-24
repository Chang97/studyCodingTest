package 문제.골드1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868_최솟값 {
  static long[] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 수의 개수
    int M = Integer.parseInt(st.nextToken()); // 변경이 일어나느 횟수
    
    int treeHeight = 0;
    int length = N;
    while (length != 0) {
      length /= 2;
      treeHeight++;
    }
    int treeSize = (int) Math.pow(2, treeHeight + 1); // 트리사이즈 -> Math.pow(2, 트리의 높이 + 1)
    int leftNodeStartIndex = treeSize / 2 - 1; // 리프노드 시작 인덱스

    tree = new long[treeSize + 1];
    // 데이터를 리프 노드에 입력받기
    for (int i = 0; i < tree.length; i++) {
      tree[i] = Integer.MAX_VALUE;
    }
    for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }

    setTree(treeSize - 1); // tree 만들기
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      s = s + leftNodeStartIndex;
      e = e + leftNodeStartIndex;
      System.out.println(getMin(s, e));
    }
    br.close();
    
  }

  private static long getMin(int s, int e) { // 구간 합을 구하는 함수
    long Min = Long.MAX_VALUE;
    while (s <= e) {
      if (s % 2 == 1) {
        Min = Math.min(Min, tree[s]);
        s++;
      }
      s = s / 2;
      if (e % 2 == 0) {
        Min = Math.min(Min, tree[e]);
        e--;
      }
      e = e / 2;
    }
    return Min;
  }

  private static void setTree(int i) { // 초기 트리를 구성하는 함수
    while (i != 1) {
      if (tree[i / 2] > tree[i])
        tree[i / 2] = tree[i];
      i--;
    }
  }
}
