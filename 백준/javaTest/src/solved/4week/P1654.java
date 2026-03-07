import java.io.*;
import java.util.*;

public class P1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > max) max = arr[i];
        }

        long lo = 1;
        long hi = max;
        long answer = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= N) {
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
