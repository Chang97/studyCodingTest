package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N + 1]; // 시간
        int[] P = new int[N + 1]; // 금액
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] D = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1) {
                D[i] = D[i + 1];
            } else {
                D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
            }
        }
        System.out.println(D[1]);
    }
}
