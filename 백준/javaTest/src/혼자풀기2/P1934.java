package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = A * B;
            while (A > 0 && B > 0) {
                if (A >= B) {
                    A = A % B;
                } else {
                    B = B % A;
                }
            }
            System.out.println(result / Math.max(A, B));
        }
    }
}
