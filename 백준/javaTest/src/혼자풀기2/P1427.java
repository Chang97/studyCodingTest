package 혼자풀기2;

import java.io.*;

public class P1427 {
  /*
    문제
    배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

    입력
    첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
   */
  /*
   * 풀이
   * 자바 내장함수를 이용해도 되지만
   * 연습용으로 선택정렬을 사용해서 품
   * 최대값을 구해서 가장 앞쪽으로 보내는 작업을 반복한다. (최대값 하나가 앞으로 가면 한칸씩 이동)
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();
    char[] arr = N.toCharArray();
    
    for (int i = 0; i < arr.length - 1; i++) {
      int max = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] > max) {
          max = arr[j];
          char temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
    System.out.println(String.valueOf(arr));

  }
  
}
