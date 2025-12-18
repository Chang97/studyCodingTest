import java.io.*;
import java.util.*;

public class P6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if (max < arr[i]) max = arr[i];
        }

        long lo = max;
        long hi = sum;
        long answer = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            int cnt = 1;
            long price = mid;

            for (int i = 0; i < N; i++) {
                if (price - arr[i] < 0) {
                    price = mid;
                    cnt++;
                }
                price -= arr[i];
            }

            if (cnt > M) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
