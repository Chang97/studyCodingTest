import java.io.*;
import java.util.*;

public class P2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int lo = 0;
        int hi = N - 1;
        long best = Long.MAX_VALUE;
        long[] answer = new long[2];
        while (lo < hi) {
            long sum = arr[lo] + arr[hi];
            long abs = Math.abs(sum);
            if (best > abs) {
                best = abs;
                answer[0] = arr[lo];
                answer[1] = arr[hi];
            }

            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                System.out.println(arr[lo] + " " + arr[hi]);
                return;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
