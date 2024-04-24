package 문제.브론즈2;

import java.util.Scanner;

/**
 * P11720_숫자의합
 * 1. N값 입력받기
 * 2. 공백 없이 주어진 N개의 숫자 입력받기
 * 3. 2 에서 문자열로 받은 후 char[] 로 변환하기
 * 4. char[] 로 변환한 배열 순회하며 int로 변경하여 sum하여 출력
 */
public class P11720_숫자의합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();

    String num = sc.next();

    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += num.charAt(i) - '0';
    }

    System.out.println(sum);
    sc.close();
  }
  
}
