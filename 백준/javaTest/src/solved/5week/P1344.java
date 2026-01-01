/*
코멘트
확률 구하는 점화식은 이해했으나 소수인 것들 판별하는 부분 이해하는데서 애먹었음.
*/

import java.io.*;
import java.util.*;

public class P1344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double A = Integer.parseInt(br.readLine()) / 100.0;
        double B = Integer.parseInt(br.readLine()) / 100.0;

        double[][] dp_A = new double[19][19];
        double[][] dp_B = new double[19][19];

        Arrays.fill(dp_A[0], 0.0);
        dp_A[0][0] = 1.0;
        Arrays.fill(dp_B[0], 0.0);
        dp_B[0][0] = 1.0;

        int[] primes = { 2, 3, 5, 7, 11, 13, 17 };
        
        for (int i = 1; i <= 18; i++) {
            for (int k = 0; k <= i; k++) {
                dp_A[i][k] += dp_A[i - 1][k] * (1 - A);
                dp_B[i][k] += dp_B[i - 1][k] * (1 - B);
                if (k > 0) {
                    dp_A[i][k] += dp_A[i - 1][k - 1] * A;
                    dp_B[i][k] += dp_B[i - 1][k - 1] * B;
                }
            }
        }

        double primeA = 0;
        double primeB = 0;

        for (int i : primes) {
            primeA += dp_A[18][i];
            primeB += dp_B[18][i];
        }

        double answer = primeA + primeB - (primeA * primeB);
        System.out.println(answer);

    }
}
