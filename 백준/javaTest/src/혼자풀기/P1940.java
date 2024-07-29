package 혼자풀기;

import java.util.*;
import java.io.*;

public class P1940 {
    /*
    1. N 입력 받기 (재료 개수)
    2. M 입력 받기 (재료의 합)
    3. N 만큼 재료 개수 입력 받기 (arr)
    4. arr 오름 차순 정렬
    5. 투 포인터로 두 수의 합이 M인 케이스 탐색 (양쪽 끝에서부터 좁혀 들어감)
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int s = 1, e = N;
        int answer = 0;
        
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum < M) {
                s++;
            } else if (sum > M) {
                e--;
            } else {
                answer++;
                s++;
            }
        }
        
        System.out.println(answer);
        br.close();
    }
}
