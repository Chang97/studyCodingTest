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
   * DFS 개념을 활요하여 푼다.
   * 각 자리수별로 모두 소수인 수를 찾아야함
   * 현재 자리수가 소수인 경우를 찾아서 자리수를 늘려가며 입력받은 N자리수가 될때까지 탐색
   * 
   */
  static int N;
  static int[] prime;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; i++) {
      sb.append("9");
    }
    prime = new int[Integer.parseInt(sb.toString()) + 1];

    // 소수판별을 위한 에라토스테네스의 체
    for (int i = 1; i < prime.length; i++) {
      prime[i] = i;
    }

    for (int i = 2; i < prime.length; i++) {
      if (prime[i] == 0) continue;
      
      for (int j = 2 * i; j < prime.length; j += i) {
        prime[j] = 0;
      }
    }


    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);

  }

  static void DFS(int num, int jarisu) {
    if (jarisu == N) {
      if (isPrime(num)) {
        System.out.println(num);
        return;
      }
    }

    for (int i = 1; i <= 9; i++) {
      if (i % 2 == 0) continue;
      if (isPrime(num * 10 + i)) {
        DFS(num * 10 + i, jarisu + 1);
      }
    }
  }

  static boolean isPrime(int num) {
    return prime[num] != 0;
  }
}
