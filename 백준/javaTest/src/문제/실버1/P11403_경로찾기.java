package 문제.실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403_경로찾기 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int distance[][];
  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    distance = new int[N][N];
    for (int i = 0; i < N; i++) { // 입력되는 인접 행렬의 값을 그대로 저장하기
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int v = Integer.parseInt(st.nextToken());
        distance[i][j] = v;
      }
    }

    for (int k = 0; k < N; k++) { // 변형된 플로이드 워셜 알고리즘 수행
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (distance[i][k] == 1 && distance[k][j] == 1) distance[i][j] = 1;
        }
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(distance[i][j] + " ");
      }
      System.out.println();
    }
  }
}
