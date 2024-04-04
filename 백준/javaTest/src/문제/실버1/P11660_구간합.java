package 문제.실버1;

/*
 * 1. 배열크기 N과 질의개수 M을 입력 받는다.
 * 2. 배열 값을 입력받는다.
 * 3. xStart, xEnd, yStart, tEnd 를 M의 개수만큼 입력 받는다.
 * 4. 구간합을 출력한다.
 */
import java.io.*;
import java.util.*;

public class P11660_구간합 {
  public static void main(String[] args) throws IOException{
    BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(rb.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[][] numArr = new long[N + 1][N + 1];
    // 구간 합
    long[][] S = new long[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(rb.readLine());
      for (int j = 1; j <= N; j++) {
        numArr[i][j] = Long.parseLong(st.nextToken());
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + numArr[i][j] ;
      }
    }

    for (int i = 0; i <= M; i++) {
      st = new StringTokenizer(rb.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      
    }


  }
}