package 문제.실버5;

/*
 * 1. N 변수 입력 받기
 * 2. 사용 변수 초기화 count = 1, start_index = 1, end_index = 1, sum = 1
 * 3. 투 포인터 이동 원칙 적용하여 탐색
 * 투 포인터 이동원칙
 * sum > N: sum = snum - start_index; start_index++;
 * sum < N: end_index++; sum = sum + end_index;
 * sum == N: end_index++; sum = sum + end_index; count++;
 * 
 * 연속된 수에 대해서는 배열을 사용하지 않고도 계산이 가능
 */
import java.util.Scanner;
public class P2018_연속된자연수합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int sum = 1;
    int count = 1;
    int start_index = 1;
    int end_index = 1;

    while (end_index != N) { // 마지막 N자체는 초기화하면서 1을 넣어줬기에 제외
      if (sum == N) { // sum 과 N이 동일
        count++;
        // sum과 N이 end_index를 확장하여 계산
        end_index++;
        sum += end_index;
      } else if (sum < N) { // sum 이 N보다 작을 때
        end_index++;
        sum += end_index;
      } else { // sum이 N보다 클 때
        sum -= start_index;
        start_index++;
      }
    }

    System.out.println(count);
    sc.close();
  }
}
