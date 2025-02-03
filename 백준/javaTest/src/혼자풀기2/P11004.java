package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11004 {
  /*
    문제
    수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

    둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

    출력
    A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
   */
  /*
   * 풀이
   * 일반적인 정렬 문제이나 연습을 위해 퀵 정렬을 사용한다.
   * 
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int pivot = arr.length / 2;
    int temp = arr[0];
    arr[0] = arr[pivot];
    arr[pivot] = temp;

    

  }
  
}
