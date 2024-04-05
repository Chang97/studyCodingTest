package 문제.실버4;
/*
 * 투 포인터
 * 1. 배열의 길이 N을 입력 받는다.
 * 2. 합을 비교할 M을 입력 받는다.
 * 3. 배열을 입력 받는다.
 * 4. 입력받은 배열을 오름차순 정렬한다.
 * 5. 좌우 끝에 인덱스를 줘서 M과 동일한 합을 카운트한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int s = 0;
    int e = N - 1;
    int armor = 0;

    while (s < e) {
      if (arr[s] + arr[e] == M ) {
        armor++;
        s++;
        e--;
      } else if (arr[s] + arr[e] > M) {
        e--;
      } else {
        s++;
      }
    }
    System.out.println(armor);
    br.close();
  }
}
