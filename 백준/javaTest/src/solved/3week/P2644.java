import java.io.*;
import java.util.*;

public class P2644 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        DFS(a, answer);

        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    static void DFS(int node, int depth) {
        visited[node] = true;
        if (node == b) {
            answer = depth;
            return;
        }
        for (int next : graph[node]) {
            if (!visited[next]) {
                DFS(next, depth + 1);
            }
        }
    }
}
