import java.io.*;
import java.util.*;
public class P2161 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
            if (!queue.isEmpty()) queue.offer(queue.poll());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
