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

        for (int i = 0; i < gcd(A, B); i++) {
            bw.write("1");
        }

        bw.flush();
        bw.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
