import java.io.*;
import java.util.*;

public class P9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int n = arr1.length;
        int m = arr2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <=n; i++) {
            char a = arr1[i - 1];
            for (int j = 1; j <= m; j++) {
                char b = arr2[j - 1];

                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);


    }
}
