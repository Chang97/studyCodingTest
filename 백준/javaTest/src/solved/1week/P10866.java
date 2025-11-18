import java.util.*;
import java.io.*;

public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.indexOf("push_back") != -1) {
                int num = Integer.parseInt(str.substring(10));
                dq.addLast(num);
            } else if (str.indexOf("push_front") != -1) {
                int num = Integer.parseInt(str.substring(11));
                dq.addFirst(num);
            } else if (str.equals("pop_front")) {
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.pollFirst()).append("\n");
            } else if (str.equals("pop_back")) {
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.pollLast()).append("\n");
            } else if (str.equals("size")) {
                sb.append(dq.size()).append("\n");
            } else if (str.equals("empty")) {
                if (dq.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (str.equals("front")) {
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.getFirst()).append("\n");
            } else if (str.equals("back")) {
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.getLast()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
