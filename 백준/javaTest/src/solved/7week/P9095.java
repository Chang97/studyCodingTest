import java.io.*;

public class P9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            if (N == 1) {
                sb.append(1).append("\n");
                continue;
            } else if (N == 2) {
                sb.append(2).append("\n");
                continue;
            } else if (N == 3) {
                sb.append(4).append("\n");
                continue;
            }
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        
    }
}
