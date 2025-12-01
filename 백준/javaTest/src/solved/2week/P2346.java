import java.io.*;
import java.util.*;

public class P2346 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Node> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dq.add(new Node(i, num));
        }

        while (true) {
            Node node = dq.poll();
            sb.append(node.index).append(" ");

            if (dq.isEmpty()) break;

            if (node.value > 0) {
                for (int i = 0; i < node.value - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i > node.value; i--) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static class Node {
        int index;
        int value;

        Node (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
