package 혼자풀기2;

import java.io.*;
import java.util.StringTokenizer;
public class P1546 {
  /*
    문제
    세준이는 기말고사를 망쳤다. 
    세준이는 점수를 조작해서 집에 가져가기로 했다. 
    일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 
    그리고 나서 모든 점수를 점수/M*100으로 고쳤다.

    예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.

    세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 
    둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.

    출력
    첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
   */
  /*
   풀이
   1. 과목수를 입력 받는다.
   2. 과목수에 맞는 점수를 입력 받으며 최대값을 찾는다.
   3. 입력받은 점수/최대값*100 을 반복문으로 다시 계산하며 평균 계산을위해 sum.
   4. 변경된 점수로 계산한 평균을 출력한다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 1
    int N = Integer.parseInt(br.readLine());
    double[] score = new double[N];
    double max = 0;
    double sum = 0;

    // 2
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      score[i] = Integer.parseInt(st.nextToken());
      if (max < score[i]) max = score[i];
    }

    // 3
    for (int i = 0; i < N; i++) {
      score[i] = score[i] / max * 100;
      sum += score[i];
    }

    System.out.println(sum / N);
  }
}
