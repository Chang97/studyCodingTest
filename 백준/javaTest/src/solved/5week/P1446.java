import java.io.*;
import java.util.*;

public class P1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            if (arr[i][0] == 0 && arr[i][1] <= D) {
                dp[arr[i][1]] = Math.min(arr[i][2], dp[arr[i][1]]);
            }
        }

        
        dp[0] = 0;
        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            for (int k = 0; k < N; k++) {
                if (arr[k][0] == i) {
                    if (arr[k][1] <= D) {
                        dp[arr[k][1]] = Math.min(dp[i] + arr[k][2], dp[arr[k][1]]);
                    }
                    
                }
            }
            
        }
        
        System.out.println(dp[D]);
    }

}
