package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P11660 {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[][] arr = new int[N + 1][N + 1];
      int[][] sum = new int[N + 1][N + 1];
      
      // 원본 배열 채우기
      for (int i = 1; i <= N; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 1; j <= N; j++) {
              arr[i][j] = Integer.parseInt(st.nextToken());
          }
      }
      
      // 합배열 값 채우기
      for (int i = 1; i <= N; i++) {
          for (int j = 1; j <= N; j++) {
              sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i][j];
          }
      }
      
      // 질의받은 좌표 구간합 출력
      for (int i = 0; i < M; i++) {
          st = new StringTokenizer(br.readLine());
          int x1 = Integer.parseInt(st.nextToken());
          int y1 = Integer.parseInt(st.nextToken());
          int x2 = Integer.parseInt(st.nextToken());
          int y2 = Integer.parseInt(st.nextToken());
          System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
      }
      
    }
}
