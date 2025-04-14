package 혼자풀기2;

import java.io.*;

public class P2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] D = new int[k + 1][n + 1];
            for (int j = 0; j <= n; j++) {
                D[0][j] = j;
            }
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    D[i][j] = D[i - 1][j] + D[i][j - 1];
                }
            }
            System.out.println(D[k][n]);
        }
    }
}

