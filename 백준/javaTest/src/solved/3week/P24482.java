import java.io.*;
import java.util.*;

public class P24482 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        Arrays.fill(depth, -1);

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i], Collections.reverseOrder());
        depth[R] = 0;
        DFS(R);

        for (int i = 1; i <= N; i++) sb.append(depth[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    static void DFS(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                depth[next] = depth[node] + 1;
                DFS(next);
            }
        }
    }
}
