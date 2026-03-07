import java.io.*;
import java.util.*;

public class P2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 5000);
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
            if (i >= 3 && dp[i - 3] != 5000) {
                dp[i] = Math.min(dp[i - 3] + 1, dp[i]);
            }
            if (i >= 5 && dp[i - 5] != 5000) {
                dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
            }
        }

        if (dp[N] == 5000) System.out.println(-1);
        else System.out.println(dp[N]);
    }
}
