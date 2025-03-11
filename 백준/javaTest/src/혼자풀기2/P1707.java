package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1707 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= V; i++) {
                if (isEven) DFS(i);
                else break;
            }
            if (isEven) System.out.println("YES");
            else System.out.println("NO");

        }
    }

    static void DFS(int x) {
        visited[x] = true;
        for (int i : list[x]) {
            if (!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리
                check[i] = (check[x] + 1) % 2;
                DFS(i);
            } else if (check[x] == check[i]) { // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
                isEven = false;
            }
        }
    }
}
