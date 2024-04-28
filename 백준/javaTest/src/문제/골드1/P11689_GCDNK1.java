package 문제.골드1;

import java.io.*;

public class P11689_GCDNK1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    long result = n;
    // 제곱근까지만 진행하기
    for (long p = 2; p <= Math.sqrt(n); p++) {
      // p가 소인수인지 확인
      if (n % p == 0) {
        // 결과값 업데이트
        result = result - result / p;
        // 2의7승 * 11 이라면 2의 7승을 없애고 11만 남김
        while (n % p == 0) {
          n /= p;
        }
      }
    }
    // 아직 소인수 구성이 남아있을 때
    if (n > 1) {
      // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
      result = result - result / n;
    }
    System.out.println(result);
  }
}
