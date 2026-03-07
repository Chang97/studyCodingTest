import java.util.*;
import java.io.*;
public class P11404 {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Edge>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }

        for (int i = 1; i <= N; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
                return Long.compare(a.c, b.c);
            });
            boolean[] visited = new boolean[N + 1];
            long[] distance = new long[N + 1];
            Arrays.fill(distance, Long.MAX_VALUE);
            pq.add(new Node(i, 0));
            distance[i] = 0;
            
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (visited[cur.b]) continue;
                visited[cur.b] = true;

                for (Edge next : list[cur.b]) {
                    if (distance[next.to] > distance[cur.b] + next.val) {
                        distance[next.to] = distance[cur.b] + next.val;
                        pq.add(new Node(next.to, distance[next.to]));
                    }
                }
            }
            
            for (int j = 1; j <= N; j++) {
                if (distance[j] == Long.MAX_VALUE) sb.append(0);
                else sb.append(distance[j]);
                
                if (j == N) sb.append("\n");
                else sb.append(" ");
            }
            
        }

        bw.write(sb.toString());
        bw.flush();
    
    }

    static class Node {
        int b;
        long c;

        Node (int b, long c) {
            this.b = b;
            this.c = c;
        }
    }

    static class Edge {
        int to;
        int val;

        Edge (int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
}
