package 혼자풀기2;

import java.io.*;

public class P2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N + 1][2];
        D[1][1] = 1;
        D[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1] + D[i - 1][0];
            D[i][1] = D[i - 1][0];
        }
        System.out.println(D[N][1] + D[N][0]);

    }
}
