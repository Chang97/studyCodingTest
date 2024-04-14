package 문제.플래티넘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517_버블소트2 {
  public static int[] A, tmp;
  public static long result;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    A = new int[N + 1];
    tmp = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    result = 0;
    merget_sort(1, N);
    System.out.println(result);
    br.close();
  }
  // s : 1, e : 5
  private static void merget_sort(int s, int e) {
    if (e - s < 1) { // e 와 s가 동일한 경우 stop
      return;
    }

    int m = s + (e - s) / 2;

    // 재귀 함수 형태로 구현
    merget_sort(s, m); // 왼쪽 쪼개기
    merget_sort(m + 1, e); // 우측 쪼개기
    for (int i = s; i <= e; i++) {
      tmp[i] = A[i];
    }
    int k = s;
    int index1 = s;
    int index2 = m + 1;

    while (index1 <= m && index2 <= e) { // 두 그룹을 병합하는 로직
      // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
      // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
      if (tmp[index1] > tmp[index2]) {
        A[k] = tmp[index2];
        result = result + index2 - k;
        k++;
        index2++;
      } else {
        A[k] = tmp[index1];
        k++;
        index1++;
      }
    }
    while (index1 <= m) { // 왼쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
      A[k] = tmp[index1];
      k++;
      index1++;
    }
    while (index2 <= e) {
      A[k] = tmp[index2];
      k++;
      index2++;
    }
  }
}
