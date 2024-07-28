package 혼자풀기;

import java.util.*;
import java.io.*;

public class P10986 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] numArr = new long[N + 1];
        int answer = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = (numArr[i - 1] + Long.parseLong(st.nextToken())) % M;
            if (numArr[i] == 0) answer++;
        }
    }
        
}
