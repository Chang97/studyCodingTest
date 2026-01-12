import java.io.*;
import java.util.*;

public class P11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Node(s, t));
        }

        Collections.sort(list, (a, b) -> {
            return Integer.compare(a.s, b.s);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 1;
        pq.add(list.get(0).t);
        for (int i = 1; i < list.size(); i++) {
            Node cur = list.get(i);
            int e = pq.peek();
            if (cur.s < e) {
                answer++;
            } else {
                pq.poll();
            }
            pq.add(cur.t);
        }

        System.out.println(answer);
    }

    static class Node {
        int s;
        int t;

        Node (int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
