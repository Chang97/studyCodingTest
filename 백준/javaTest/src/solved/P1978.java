package solved;

import java.util.*;
import java.io.*;

public class P1978 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1001];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= 1000; i++) {
            if (prime[i]) continue;
            for (int j = i * i; j <= 1000; j+=i) {
                prime[j] = true;
            }
        }

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (!prime[val]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
