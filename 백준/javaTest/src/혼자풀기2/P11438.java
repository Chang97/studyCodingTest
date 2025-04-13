package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11438 {
    static List<Integer>[] tree;
    static int[] depth;
    static int kMax;
    static int[][] parent;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[N + 1];
        visited = new boolean[N + 1];
        int temp = 1;
        kMax = 0;
        while (temp <= N) { // 최대 가능 depth 구하기
            temp <<= 1; // 거듭제곱곱
            kMax++;
        }
        parent = new int[kMax + 1][N + 1];
        BFS(1);
        for (int k = 1; k <= kMax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        }

    }

    static int excuteLCA(int a, int b) {
        if (depth[a] > depth[b]) { // 더 깊은 depth가 b가 되게 변경
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k = kMax; k >= 0; k--) { // depth 빠르게 맞추기
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        for (int k = kMax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        
        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;

    }
    static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        int level = 1;
        int nowSize = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    parent[0][next] = now; // 부모 노드 저장
                    depth[next] = level; // 노드 depth 저장
                }
            }
            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }
}
