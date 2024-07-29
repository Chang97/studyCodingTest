package 혼자풀기;

import java.util.*;
import java.io.*;

public class P1253 {
    /*
    1. N 입력
    2. N 만큼 수 입력 받기
    3. 숫자 하나씩 찍어서 투포인터 돌리기 
    4. 좋은수 카운트
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < N; i++) {
          int s = 0, e = N - 1;
            while (s < e) {
                long sum = arr[s] + arr[e];
                if (s == i) {
                  s++;
                  continue;
                }
                if (e == i) {
                  e--;
                  continue;
                }
                
                if (sum < arr[i]) {
                    s++;
                } else if (sum > arr[i]) {
                    e--;
                } else {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
