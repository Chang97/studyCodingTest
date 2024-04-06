package 문제.골드4;
/**
 * P1253_좋다
 * 1. 수의 개수 N을 입력 받는다.
 * 2. N개의 수를 입력 받는다.
 * 3. 입력 받은 수를 오름차순 정렬한다.
 * 4. 좋은 수를 탐색한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋다 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int s = 0;
    int e = N - 1;
    int count = 0;

    for (int i = 0; i < N; i++) {
      // 초기화
      s = 0;
      e = N - 1;
      while (s < e) {
        if (arr[s] + arr[e] == arr[i]) {
          if (s != i && e != i) { // 서로 다른 수의 합인지 체크
            count++;
            // while문 stop
            break;
          } else if (s == i) { // 같다면 startIndex하나 늘려서 같지않게 피해줌
            s++;
          } else if (e == i) { // 같다면 endIndex하나 줄여서 같지않게 피해줌
            e--;
          }
          
        } else if (arr[s] + arr[e] < arr[i]) {
          s++;
        } else {
          e--;
        }
      }
    }
    System.out.println(count);
    br.close();
  }
}