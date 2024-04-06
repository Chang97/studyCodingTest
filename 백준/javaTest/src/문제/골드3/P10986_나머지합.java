package 문제.골드3;

/*
 * 나머지 합 구하기
 * 1. 첫번째 줄에서 N(입력받을 수의 개수)과 M(나눌 수)을 입력받는다.
 * 2. 두번째 줄에서 N개의 수를 입력 받는다.
 * 3. 입력받은 수의 합배열 생성
 * 4. 합배열 각인덱스 별로 %M 계산하여 각 나머지 별 카운트 배열에 카운트업 및 나머지가 0이면 정답에 추가
 * 5. 합배열에서 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986_나머지합 {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 1.
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    long[] S = new long[N];
    long[] C = new long[M];
    long answer = 0;

    // 2.
    // 수열 합 배열 만들기
    S[0] = Long.parseLong(st.nextToken());
    for (int i = 1; i < N; i++ ) {
      S[i] = S[i - 1] + Long.parseLong(st.nextToken());
    }
    
    // 3.
    // 합 배열의 모든 값에 % 연산 수행하기
    for (int i = 0; i < N; i++) {
      int remainder = (int) (S[i] % M);
      // 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
      if (remainder == 0) answer++;
      // 나머지가 같은 인덱스의 개수 카운팅 하기
      C[remainder]++;
    }

    for (int i = 0; i < M; i++) {
      if (C[i] > 1) {
        // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
        answer = answer + (C[i] * (C[i] - 1) / 2);
      }
    }

    System.out.println(answer);


  }
}
