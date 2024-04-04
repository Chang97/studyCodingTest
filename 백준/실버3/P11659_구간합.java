package 백준.실버3;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 1. 수의 개수 N을 입력 받는다.
 * 2. 구해야 하는 횟수 M을 입력 받는다.
 * 3. 둘째줄에는 N개의 수가 주어진다.
 */
public class P11659_구간합 {
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] numArr = new int[N + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      numArr[i] = numArr[i - 1] + Integer.parseInt(st.nextToken());
    }
    int[] answer = new int[M];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int sNum = Integer.parseInt(st.nextToken());
      int eNum = Integer.parseInt(st.nextToken());
      answer[i] = numArr[eNum] - numArr[sNum - 1];
    }

    for (int i : answer) {
      System.out.println(i);
    }
  }
}
