package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1753 {
    static List<Node>[] list; // 그래프 정보
    static int[] distance; // 최단거리
    static boolean[] visited; // 방문여부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 노드개수
        int E = Integer.parseInt(st.nextToken()); // 에지 개수
        int K = Integer.parseInt(br.readLine()); // 출발 노드
        // 초기화
        list = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        // 에지 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        // 거리 오름차순 우선순위큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.value - o2.value;
        });

        
        pq.add(new Node(K, 0));
        distance[K] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.next;
            if (visited[now]) continue;
            visited[now] = true;
            for (Node temp : list[now]) {
                int next = temp.next;
                int val = temp.value;
                if (distance[next] > distance[now] + val) {
                    distance[next] = distance[now] + val; // 최단거리 업데이트
                    pq.add(new Node(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
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
