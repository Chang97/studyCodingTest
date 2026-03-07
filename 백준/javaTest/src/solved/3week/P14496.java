import java.io.*;
import java.util.*;

public class P14496 {
    static List<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i]);

        DFS(R, 0);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        
    }

    static void DFS(int node, int depth) {
        visited[node] = depth;

        for (int next : graph[node]) {
            if (visited[next] == -1) {
                DFS(next, depth + 1);
            }
        }
    }
}