import java.io.*;
import java.util.*;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int cnt = 0;
        bw.write("<");
        while (!queue.isEmpty()) {
            cnt++;
            if (cnt == K) {
                bw.write(String.valueOf(queue.poll()));
                if (!queue.isEmpty()) bw.write(", ");
                cnt = 0;
            } else {
                queue.add(queue.poll());
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
        br.close();

    }
}
