package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P2023 {
  /*
    문제
    수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 
    요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.

    7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 
    즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.

    수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.

    입력
    첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

    출력
    N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
   */
  /*
   * 풀이
   * 1. DFS 개념을 활용해서 풀이
   * 2. 입력받은 N기준으로 N의자리수 숫자중 신기한 소소를찾아야함.
   * 3. 왼쪽부터 자릿수를 하나씩 늘려가며 소수여야하니 1의 자리일 때 소수인 2,3,5,7 기준으로 DFS탐색
   *    - 탐색은 연결리스트를 사용하지 않지만 개념은 가져간다.
   *    - 현재 입력받은 자리수가 N과 동일하며 판별할 숫자가 소수인 경우 해당 숫자를 출력한다.
   *    - 그게 아닌경우는 입력받은 숫자 자리수 하나 올린 후 1~9까지 넣어가며 소수인지 판별
   *    - 만약 소수인 경우에는 자리수를 하나 올려서 해당 숫자를 DFS 호출 (재귀)
   * 
   * ** 잘못 생각한 부분, 소수 판별을 위해 에라토스테네스의 체를 사용하려 헀으나
   *    메모리 초과로 일반적인 소수판별로직을 사용했음. (메모리 제한 4MB,  int[] 크기가 100000000인 경우 100MB)
   */
  static int N;
  static int[] prime;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);


  }

  static void DFS(int num, int jarisu) {
    if (jarisu == N) {
      if (isPrime(num)) {
        System.out.println(num);
      }
      return;
    }

    for (int i = 1; i <= 9; i++) {
      if (i % 2 == 0) continue;
      if (isPrime(num * 10 + i)) {
        DFS(num * 10 + i, jarisu + 1);
      }
    }
  }

  static boolean isPrime (int num) {
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
