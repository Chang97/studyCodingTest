import java.io.*;
import java.util.*;

public class P2003 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        int answer = 0;
        while (true) {
            if (sum >= M) {
                if (sum == M) {
                    answer++;
                }
                sum -= arr[s++];
            } else {
                if (e == N) break;
                sum += arr[e++];
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();;
        bw.close();
        br.close();

    }
}
