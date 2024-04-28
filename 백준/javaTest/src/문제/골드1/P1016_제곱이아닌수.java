package 문제.골드1;

import java.util.*;

public class P1016_제곱이아닌수 {
  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    long Min = sc.nextLong();
    long Max = sc.nextLong();

    // 최댓값과 최솟값의 차이만큼 배열 선언하기
    boolean[] Check = new boolean[(int) (Max - Min + 1)];
    // 2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
    for (long i = 2; i * i <= Max; i++) {
      long pow = i * i; // 제곱 수
      long start_index = Min / pow;
      if (Min % pow != 0) {
        // 나머지가 있으면 1을 더해야 Min보다 큰 제곱수에서 시작됨
        start_index++;
      }
      for (long j = start_index; pow * j <= Max; j++) {
        Check[(int) ((j * pow) - Min)] = true;
      }
    }
    int count = 0;
    for (int i = 0; i <= Max - Min; i++) {
      if (!Check[i]) {
        count++;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
