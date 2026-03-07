import java.io.*;
import java.util.*;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        long max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long h = Integer.parseInt(st.nextToken());
            trees[i] = h;
            if (max < h) max = h;
        }

        long lo = 0;
        long hi = max;
        long answer = 0;
        while (lo <= hi) {
            long sum = 0;
            long mid = lo + (hi - lo) / 2;
            for (int i = 0; i < N; i++) {
                long h = trees[i] - mid;
                if (h > 0) sum += h;
            }

            if (M <= sum) {
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
