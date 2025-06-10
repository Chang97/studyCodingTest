package solved;

import java.io.*;
import java.util.*;

public class P30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] shirts = new int[6];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < shirts.length; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result1 = 0;
        int result2 = 0;
        int result3 = 0;

        for (int i = 0; i < shirts.length; i++) {
            int result = shirts[i] / T;
            if (shirts[i] % T > 0) result++;
            result1 += result;
        }
        result2 = N / P;
        result3 = N % P;

        System.out.println(result1);
        System.out.println(result2 + " " + result3);
    }
}
