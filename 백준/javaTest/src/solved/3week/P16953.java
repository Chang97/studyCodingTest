import java.io.*;
import java.util.*;

public class P16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(a, 1));
        while (!q.isEmpty()) {
            Node node = q.poll();
            long val = node.val;
            int depth = node.depth;

            if (val == b) {
                System.out.println(depth);
                return;
            }
            if (val * 2 <= b) q.offer(new Node(val * 2, depth + 1));
            long num = Long.parseLong(String.valueOf(val) + "1");
            if (num <= b) q.offer(new Node(num, depth + 1));
            
        }

        System.out.println(-1);
    }

    static class Node {
        long val;
        int depth;

        Node (long val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
}
