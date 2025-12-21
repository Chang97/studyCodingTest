import java.io.*;
import java.util.*;

public class P2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[M];
        long max = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (max < arr[i]) max = arr[i];
        }

        Arrays.sort(arr);

        long lo = 0;
        long hi = max;
        long answer = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = 0;

            for (int i = 0; i < M; i++) {
                cnt += Math.ceil((double) arr[i] / mid);
                if (cnt > N) break;
            }

            if (cnt <= N) {
                hi = mid - 1;
                answer = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
