import java.io.*;
import java.util.*;

public class P17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] I = new int[K];
        int[] T = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            I[i] = Integer.parseInt(st.nextToken());
            T[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < K; i++) {
            for (int j = N; j >= T[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - T[i]] + I[i]);
            }
        }

        System.out.println(dp[N]);

    }
}
