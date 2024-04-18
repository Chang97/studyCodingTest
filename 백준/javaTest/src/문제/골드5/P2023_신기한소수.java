package 문제.골드5;


import java.io.*;
import java.util.*;
public class P2023_신기한소수 {
  static int N;
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    // 1자리수 소수인 2, 3, 5, 7만 가지치기하여 시작
    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
  }

  static void DFS(int number, int jarisu) {
    if (jarisu == N) {
      if (isPrime(number)) {
        System.out.println(number);
      }
      return;
    }
    for (int i = 1; i < 10; i++) {
      // 짝수는 소수가 아니기에 제외
      if (i % 2 == 0) {
        continue;
      }
      // number * 10 + i 로 자리수를 증가시키며 재귀
      if (isPrime(number * 10 + i)) {
        DFS(number * 10 + i, jarisu + 1);
      }
    }
  }
  static boolean isPrime(int num) {
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
