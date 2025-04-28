package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] items = new int[M];
        int T = 0;
        for (int i = 0; i < M; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            T += items[i];
        }
        int K = Integer.parseInt(br.readLine());
        
        double ans = 0.0;
        double[] prob = new double[M];
        for (int i = 0; i < M; i++) {
            if (items[i] >= K) {
                prob[i] = 1.0;
                for (int k = 0; k < K; k++) {
                    prob[i] *= (double) (items[i] - k) / (T - k);
                }
                ans += prob[i];
            }
        }
        System.out.println(ans);
    }
}
