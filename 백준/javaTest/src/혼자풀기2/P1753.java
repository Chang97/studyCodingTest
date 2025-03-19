package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1753 {
    static List<Node>[] list;
    static int[] distance;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 노드개수
        int E = Integer.parseInt(st.nextToken()); // 에지 개수
        int K = Integer.parseInt(br.readLine()); // 출발 노드
        list = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        


    }

    static class Node {
        int next;
        int value;

        Node (int next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}
