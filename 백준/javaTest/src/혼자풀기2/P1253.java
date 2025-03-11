package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1253 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    // 오름차순 정렬
    Arrays.sort(arr); 

    int result = 0; // 정답 변수
    for (int i = 0; i < N; i++) {
      long K = arr[i]; // 좋은수인지 판별
      int s = 0; // 시작인덱스
      int e = N - 1; // 종료인덱스
      while (s < e) {
        if (s == i) { // 자기자신은 제외
          s++; continue;
        }

        if (e == i) { // 자기자신은 제외
          e--; continue;
        }

        long sum = arr[s] + arr[e];
        if (sum > K) {
          e--;
        } else if (sum < K) {
          s++;
        } else { // 좋은수인 경우 정답 카운트 반복 종료
          result++;
          break;
        }
      }
    }
    System.out.println(result);

    
  }
}

