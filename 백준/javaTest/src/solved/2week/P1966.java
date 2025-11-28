import java.io.*;
import java.util.*;

public class P1966 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Queue<Node> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int weight = Integer.parseInt(st.nextToken());
                Node node = new Node(i, weight);
                queue.add(node);
                pq.add(weight);
            }
            int answer = 1;
            while (!queue.isEmpty()) {
                if (pq.peek() == queue.peek().value) {
                    if (queue.peek().index == M) {
                        bw.write(String.valueOf(answer));
                        bw.newLine();
                        break;
                    }
                    answer++;
                    queue.poll();
                    pq.poll();
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        bw.flush();
    }

    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
