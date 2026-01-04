import java.io.*;
import java.util.*;

public class P1679 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int K = Integer.parseInt(br.readLine());

        int limit = max * K + 1;
        int INF = Integer.MAX_VALUE;

        int[] dp = new int[limit + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= 5000; i++) {
            for (int j = 0; j < N; j++) {
                if (i - arr[j] >= 0 && dp[i - arr[j]] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }

            if (dp[i] > K) {
                String winner = (i % 2 == 0) ? "holsoon" : "jjaksoon";
                System.out.println(winner + " win at " + i);
                return;
            }
        }
    }
}
