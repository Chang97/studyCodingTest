package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P21568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long[] xy = new long[2];
        long gcd = gcd(A, B, xy);

        if (C % gcd != 0) {
            System.out.println("-1");
            return;
        } else {
            long mok = (long) (C / gcd);
            System.out.println(xy[0] * mok + " " + xy[1] * mok);

        }

    }

    static long gcd(long a, long b, long[] xy) {
        if (b == 0) {
            // 이전값이 없으므로 x = 1, y = 0
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        long[] temp = new long[2];
        long gcd = gcd(b, a % b, temp);
        xy[0] = temp[1]; // 이전 y
        xy[1] = temp[0] - temp[1] * (a / b); // 이전 x - 이전 y * 몫
        return gcd;
    }
    
}
