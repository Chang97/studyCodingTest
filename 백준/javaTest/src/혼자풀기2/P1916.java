package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[N + 1];
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, p));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1 ,o2) -> Integer.compare(o1.w, o2.w));

        pq.add(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.v;
            if (distance[now] < nowNode.w) continue;
            for (Node nextNode : list[now]) {
                int next = nextNode.v;
                int value = nextNode.w;
                if (distance[next] > distance[now] + value) {
                    distance[next] = distance[now] + value;
                    pq.add(new Node(next, distance[next]));
                }
            }
        }
        System.out.println(distance[end]);
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
