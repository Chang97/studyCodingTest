package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] uf = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            uf[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }

        long result = 0;
        int cnt = 0;
        while (cnt < V - 1) {
            Edge edge = pq.poll();
            int s = edge.node1;
            int e = edge.node2;
            long v = edge.value;

            if (find(uf, s) != find(uf, e)) {
                union(uf, s, e);
                result += v;
                cnt++;
            }
        }
        System.out.println(result);
    }

    static void union (int[] uf, int a, int b) {
        a = find(uf, a);
        b = find(uf, b);

        if (a != b) uf[b] = a;
    }

    static int find (int[] uf, int a) {
        if (uf[a] == a) return a;
        else return uf[a] = find(uf, uf[a]);
    }

    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        long value;

        Edge (int node1, int node2, long value) {
            this.node1 = node1;
            this.node2 = node2;
            this.value = value;
        }

        @Override
        public int compareTo (Edge o) {
            return Long.compare(this.value, o.value);
        }
    }
}
