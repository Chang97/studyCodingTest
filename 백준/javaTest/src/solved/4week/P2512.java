
import java.io.*;
import java.util.*;

public class P2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long sum = 0;
        long max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
            if (max < arr[i]) max = arr[i];
        }

        long M = Long.parseLong(br.readLine());

        if (sum <= M) {
            System.out.println(max);
            return;
        }

        long lo = 0;
        long hi = max;
        long answer = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            sum = 0;

            for (int i = 0; i < N; i++) {
                sum += arr[i] > mid ? mid : arr[i];
            }

            if (sum <= M) {
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
