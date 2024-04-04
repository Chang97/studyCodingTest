package 문제.브론즈1;

import java.util.Scanner;

/*
 * 1. 과목의 개수를 입력 받는다.
 * 2. 각 과목별 점수를 입력 받는다.
 * 3. 점수중 최대값을 구한다. (반복문)
 * 4. 각 과목별 점수를 재계산 한다. score / max * 100
 * 5. 재계산된 과목별 점수를 출력한다.
 * 
 */
public class P1546_평균 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    int[] score = new int[cnt];

    for (int i = 0; i < score.length; i++) {
      score[i] = sc.nextInt();
    }

    double sum = 0;
    int max = 0;
    for (int i = 0; i < score.length; i++) {
      if (max < score[i]) max = score[i];
      sum += score[i];
    }
    System.out.println(sum / max * 100 / cnt);
  }
}
