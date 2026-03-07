import java.io.*;
import java.util.*;

public class P11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] answer = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int s = 0;
            int e = N - 1;
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) answer[s++] = arr[i - 1];
                else answer[e--] = arr[i - 1];
            }

            int max = Math.abs(answer[0] - answer[N - 1]);
            for (int i = 1; i < N; i++) {
                int abs = Math.abs(answer[i] - answer[i - 1]);
                if (max < abs) max = abs;
            }
            sb.append(max).append("\n");
        }
        
        System.out.println(sb.toString());

    }
}
