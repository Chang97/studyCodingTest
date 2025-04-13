package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11437 {
    static List<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        BFS(1);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 공통 조상을 구할 두 노드
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(excuteLCA(a, b));
        }
    }
    static int excuteLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (depth[a] != depth[b]) { // 두 노드의 depth 맞추기
            a = parent[a];
        }
        while (a != b) { // 같은 조상이 나올 때까지 한 칸씩 올리기
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : tree[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = now_node; // 부모 노드 저장
                    depth[i] = level; // 노드 depth 저장
                }
            }
            count++;
            if (count == now_size) { // 이번 높이에 해당하는 모든 노드를 방문했을 때
                count = 0;
                now_size = queue.size();
                level++; // depth 1 증가
            }
        }
    }
}
