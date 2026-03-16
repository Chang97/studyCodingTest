import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sums = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sums[i] = arr[i] + sums[i - 1];
        }

        int s = 0;
        int e = 1;
        int answer = Integer.MAX_VALUE;
        while (s < e) {
            if (e > N) break;
            long sum = sums[e] - sums[s];

            if (sum >= S) {
                answer = Math.min(e - s, answer);
                s++;
            } else if (sum < S) {
                e++;
            }
        }

        if (answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);

    }
}