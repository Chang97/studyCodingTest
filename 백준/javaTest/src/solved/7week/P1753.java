import java.io.*;
import java.util.*;

public class P1753 {
    static List<Node>[] list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = Integer.MAX_VALUE;

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        answer = new int[V + 1];
        Arrays.fill(answer, INF);

        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });

        pq.add(new Node(K, 0));
        answer[K] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Node next : list[cur.v]) {
                if (answer[next.v] > answer[cur.v] + next.w) {
                    answer[next.v] = answer[cur.v] + next.w;
                    pq.add(new Node(next.v, answer[next.v]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (answer[i] == INF) sb.append("INF");
            else sb.append(answer[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }

    static class Node {
        int v;
        int w;

        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
