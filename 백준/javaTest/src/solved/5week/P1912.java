import java.util.*;
import java.io.*;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        dp[0] = arr[0];
        int answer = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + arr[i]);
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
