import java.io.*;
import java.util.*;

public class P9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][N];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[2][0] = 0;

            for (int i = 1; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
                dp[2][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[0][i - 1]));
            }

            int answer = Math.max(dp[0][N - 1], Math.max(dp[1][N - 1], dp[2][N - 1]));
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
    
}
