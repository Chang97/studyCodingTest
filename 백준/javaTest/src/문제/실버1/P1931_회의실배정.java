package 문제.실버1;

import java.util.*;
import java.io.*;

public class P1931_회의실배정 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[][] A = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      A[i][0] = Integer.parseInt(st.nextToken());
      A[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A, new Comparator<int[]> () {
      @Override
      public int compare(int[] S, int[] E) {
        if (S[1] == E[1]) { // 종료 시간이 같을 때
          return S[0] - E[0];
        }
        return S[1] - E[1];
      }
    });
    int cnt = 0;
    int end = -1;

    for (int i = 0; i < N; i++) {
      if (A[i][0] >= end) { // 겹치지 않는 다음 회의가 나온 경우
        end = A[i][1];
        cnt++;
      }
    }

    System.out.println(cnt);
    br.close();
  }
}
