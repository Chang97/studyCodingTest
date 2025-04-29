package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[N + M + 1][N + M + 1];

        for (int i = 0; i <= N + M; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                    if (D[i][j] > 1000000000) D[i][j] = 1000000001;
                }
            }
        }

        if (D[N + M][M] < K) {
            System.out.println("-1");
        } else {
            while (!(N == 0 && M == 0)) {
                if (D[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K = K - D[N - 1 +M][M];
                    M--;
                }
            }
        }
    }
    
}
