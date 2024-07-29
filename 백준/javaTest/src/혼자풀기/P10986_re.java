package 혼자풀기;

import java.util.*;
import java.io.*;

public class P10986_re {
    /*
     1. N M 입력받기
     2. N만큼 숫자 입력받으며 구간합 배열 생성
     3. 구간합 배열 % M update, % M이 0이면 answer++
     4. 다시 풀기
     */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] numArr = new long[N + 1];
        long[] rArr = new long[N + 1];
        long answer = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = (numArr[i - 1] + Long.parseLong(st.nextToken()));
            int remainder = (int) (numArr[i] % M);
            if (remainder == 0) answer++;
            rArr[remainder]++;
        }
        
        for (int i = 0; i < M; i++) {
            if (rArr[i] > 1) {
                answer = answer + (rArr[i] * (rArr[i] - 1) / 2);
            }
        }
        System.out.println(answer);
        br.close();
    }
        
}
