package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1253 {
  /*
    문제
    N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

    N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

    수의 위치가 다르면 값이 같아도 다른 수이다.

    입력
    첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 
    두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

    출력
    좋은 수의 개수를 첫 번째 줄에 출력한다.
   */
  /*
   * 풀이
   * 1. N 입력받고
   * 2. N 만큼 숫자 입력받고
   * 3. 입력받은 값 오름차순 정렬
   * 4. 순차적으로 반복문 돌면서 좋은수 인지 판별
   * 5. 음수까지 고려해서 index범위설정 잘 해야함 시작부터 끝까지로
   * 
   * * 문제를 잘못봐서 좋은수 만들 수 있는 숫자 조합 세면서 값 안맞는다고 삽질함
   * * 문제를 잘 읽자...
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(arr);
    int result = 0;
    for (int i = 0; i < N; i++) {
      long K = arr[i];
      int s = 0;
      int e = N - 1;
      while (s < e) {
        if (s == i) {
          s++; continue;
        }

        if (e == i) {
          e--; continue;
        }

        long sum = arr[s] + arr[e];
        if (sum > K) {
          e--;
        } else if (sum < K) {
          s++;
        } else {
          result++;
          break;
        }
      }
    }
    System.out.println(result);

    
  }
}

