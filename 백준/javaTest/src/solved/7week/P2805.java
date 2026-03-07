import java.util.*;
import java.io.*;
public class P2805{
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        for (int i = 1; i <= N; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
                return Integer.compare(a.c, b.c);
            });
            boolean[] visited = new boolean[N + 1];
            long[] distance = new long[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            pq.add(new Node(i, 0));
            distance[i] = 0;
            
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (visited[cur.b]) continue;
                visited[cur.b] = true;

                for (Node next : list[cur.b]) {
                    if (distance[next.b] > distance[cur.b] + next.c) {
                        distance[next.b] = distance[cur.b] + next.c;
                        pq.add(next);
                    }
                }
            }
            
            for (int j = 1; j <= N; j++) {
                sb.append(distance[j]);
                if (j == N) sb.append("\n");
                else sb.append(" ");
            }
            
        }

        bw.write(sb.toString());
        bw.flush();
    
    }

    static class Node {
        int b;
        int c;

        Node (int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
}
