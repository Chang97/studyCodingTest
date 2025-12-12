import java.io.*;
import java.util.*;

public class P24445 {
    static List<Integer>[] graph;
    static int[] visited;
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

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(R);
        visited[R] = cnt;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (visited[next] == 0) {
                    q.offer(next);
                    visited[next] = ++cnt;
                }
            }
        }

        for (int i = 1; i <= N; i++) sb.append(visited[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();

    }
}