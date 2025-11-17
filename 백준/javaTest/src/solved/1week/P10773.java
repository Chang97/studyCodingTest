import java.util.*;
import java.io.*;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;

        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) dq.pop();
            else dq.push(n);
        }

        while (!dq.isEmpty()) {
            answer += dq.pop();
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
