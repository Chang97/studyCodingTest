import java.io.*;
import java.util.*;

public class P2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= k)dp[arr[i]] = 1;
        }
        
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= arr[j] && dp[i] != 10001) {
                    if (i + arr[j] <= k) dp[i + arr[j]] = Math.min(dp[i + arr[j]], dp[i] + 1);
                }
            }
        }

        if (dp[k] == 10001) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
