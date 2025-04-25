package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] D = new int[31][31];
        for (int i = 0; i < 31; i++) {
            D[i][1] = i;
            D[i][i] = 1;
            D[i][0] = 1;
        }

        for (int i = 2; i < 31; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int  t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(D[b][a]);
        }
        
    }
}
