import java.io.*;
import java.util.*;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int t = 0; t < N; t++) {
            String str = br.readLine();

            if (str.equals("pop")) {
                if (queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.poll()).append("\n");
            } else if (str.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (str.equals("empty")) {
                if (queue.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (str.equals("front")) {
                if (queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.getFirst()).append("\n");
            } else if (str.equals("back")) {
                if (queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.getLast()).append("\n");
            } else {
                int num = Integer.parseInt(str.substring(5));
                queue.add(num);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
