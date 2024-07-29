package 혼자풀기;

import java.util.*;
import java.io.*;

public class P12891 {
    static int[] acgt = new int[4]; // acgt 개수
    static int[] temp = new int[4]; // 입력받은 문자열 acgt 개수
    
    /*
    1. S (문자열길이) P(슬라이드윈도우길이) 입력 받기 
    2. DNA 문자열 입력
    3. ACGT 개수 입력
    4. 윈도우 범위 내부에서 ACGT 카운트해서 temp에 반영
    5. 비교연산 후 정답 출력
    */

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }
        if (check()) {
            answer++;
        }
        int s = 0, e = P - 1;
        while (e < S - 1) {
            rm(arr[s]);
            s++; e++;
            add(arr[e]);
            if (check()) {
                answer++;
            }
        }
        
        System.out.println(answer);
        br.close();
        
    }
    public static void add(char c) {
        if (c == 'A') {
            temp[0]++;
        } else if (c == 'C') {
            temp[1]++;
        } else if (c == 'G') {
            temp[2]++;
        } else if (c == 'T') {
            temp[3]++;
        }
    }
    public static void rm(char c) {
        if (c == 'A') {
            temp[0]--;
        } else if (c == 'C') {
            temp[1]--;
        } else if (c == 'G') {
            temp[2]--;
        } else if (c == 'T') {
            temp[3]--;
        }
    }

    public static boolean check() {
      return temp[0] >= acgt[0] && temp[1] >= acgt[1] && temp[2] >= acgt[2] && temp[3] >= acgt[3];
    }
}
