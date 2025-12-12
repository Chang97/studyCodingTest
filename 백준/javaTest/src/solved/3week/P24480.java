import java.io.*;
import java.util.*;

public class P24480 {
    static List<Integer>[] graph;
    static int[] visited;
    static int count = 0;
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

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) Collections.sort(graph[i], Collections.reverseOrder());

        DFS(R);

        for (int i = 1; i <= N; i++) sb.append(visited[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    static void DFS(int node) {
        visited[node] = ++count;

        for (int next : graph[node]) {
            if (visited[next] == 0) {
                DFS(next);
            }
        }
    }
}
