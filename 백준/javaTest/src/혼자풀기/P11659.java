package 혼자풀기;

import java.util.*;
import java.io.*;
public class P11659 {
    /**
    1. 첫째줄 정수 N, M을 입력받음.
    2. 둘째줄 N개의 숫자를 입력받음.
    3. M만큼 구간 i와 j를 입력받음.
    4. 주어진 i j 구간 합 출력 (구간합 구하는 공식 s에서 e까지 sumArr[e] - sumArr[s - 1])
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i - 1] + num;
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[e] - sumArr[s - 1]);
        }
        br.close();
    }
}
