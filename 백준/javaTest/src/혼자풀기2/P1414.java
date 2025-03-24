package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1414 {
    static int[] uf;
    static int N, sum;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        for (int i = 0; i < N; i++) {
            char[] tempc = br.readLine().toCharArray();
            for (int j = 0; j < tempc.length; j++) {
                char c = tempc[j];
                int temp = 0;
                if (c >= 'a' && c <= 'z') {
                    temp = c - 'a' + 1;
                } else if (c >= 'A' && c <= 'Z') {
                    temp = c - 'A' + 27;
                }
                sum += temp; // 총 랜선길이 저장
                if (i != j && temp != 0) pq.add(new Edge(i, j, temp));
            }
        }
        uf = new int[N];
        for (int i = 0; i < uf.length; i++) uf[i] = i;
        int useEdge = 0;
        int result = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.node1) != find(edge.node2)) {
                union(edge.node1, edge.node2);
                useEdge++;
                result += edge.value;
            }
        }

        if (useEdge == N - 1) System.out.println(sum - result);
        else System.out.println(-1);
    }

    static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) uf[b] = a;
    }
    static int find (int a) {
        if (uf[a] == a) return a;
        else return uf[a] = find(uf[a]);
    }

    static class Edge {
        int node1;
        int node2;
        int value;

        public Edge(int node1, int node2, int value) {
            this.node1 = node1;
            this.node2 = node2;
            this.value = value;
        }
    }
}
