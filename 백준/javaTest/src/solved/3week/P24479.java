import java.io.*;
import java.util.*;

public class P24479 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] visitCnt;
    static int cnt = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        visitCnt = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        DFS(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visitCnt[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void DFS(int node) {
        visited[node] = true;
        visitCnt[node] = cnt++;

        for (int next : graph[node]) {
            if (!visited[next]) DFS(next);
        }
    }
}
