import java.io.*;
import java.util.*;

public class P18126 {
    static List<Node>[] graph;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dist = new long[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        DFS(new Node(1, 0));

        long max = 0;

        for (int i = 1; i <= N; i++) {
            if (max < dist[i]) max = dist[i];
        }

        System.out.println(max);

    }

    static void DFS(Node node) {
        int v = node.v;
        long w = node.w;
        if (dist[v] > w) return;
        dist[v] = w;

        for (Node next : graph[v]) {
            int nv = next.v;
            long nw = next.w;

            if (dist[nv] == 0 && nv != 1) {
                DFS(new Node(nv, nw + w));
            }
        }
    }


    static class Node {
        int v;
        long w;

        Node (int v, long w) {
            this.v = v;
            this.w = w;
        }

    }
}