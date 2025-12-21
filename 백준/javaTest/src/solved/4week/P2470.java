import java.io.*;
import java.util.*;

public class P2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long[] answer = new long[2];
        long min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = N - 1;
        while (s < e) {
            long sum = arr[s] + arr[e];
            long absSum = Math.abs(sum);

            if (absSum < min) {
                min = absSum;
                answer[0] = arr[s];
                answer[1] = arr[e];
            }
            if (sum > 0) {
                e--;
            } else if (sum < 0) {
                s++;
            } else {
                answer[0] = arr[s];
                answer[1] = arr[e];
                break;
            }

        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
