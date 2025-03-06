package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        while (A > 0 && B > 0) {
            if (A >= B) {
                A = A % B;
            } else {
                B = B % A;
            }
        }

        for (int i = 0; i < Math.max(A, B); i++) {
            bw.write("1");
        }

        bw.flush();
        bw.close();
    }
}
