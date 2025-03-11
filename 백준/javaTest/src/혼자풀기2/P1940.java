package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1940 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int s = 0;
    int e = arr.length - 1;
    int result = 0;

    while (s < e) {
      if (arr[s] + arr[e] > M) {
        e--;
      } else if (arr[s] + arr[e] < M) {
        s++;
      } else {
        result++;
        s++;
      }
    }

    System.out.println(result);

  }
}
