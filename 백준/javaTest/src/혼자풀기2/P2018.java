package 혼자풀기2;

import java.io.*;

public class P2018 {
  /*
    문제
    어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 
    당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 
    이때, 사용하는 자연수는 N이하여야 한다.

    예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.

    N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

    입력
    첫 줄에 정수 N이 주어진다.

    출력
    입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오
    */
  /*
    * 풀이
    * 1. N 입력받고
    * 2. s(시작점), e(끝점) 1로 잡고 범위 합이 N보다 크면 e증가, sum + e, 범위 합이 N보다 작으면 s증가, sum - s
    */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1
    int N = Integer.parseInt(br.readLine());

    //3
    int s = 1;
    int e = 1;
    int sum = 1; // 1부터 시작하니 초기값 1
    int result = 0;

    while(s <= N) {
      if (sum > N) {
        sum -= s++;
      } else if (sum < N){
        sum += ++e;
      } else {
        result++;
        sum += ++e;
      }
    }

    System.out.println(result);
  }
}
