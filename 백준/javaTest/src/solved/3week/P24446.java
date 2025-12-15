import java.io.*;
import java.util.*;

public class P24446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(R);
        visited[R] = true;
        dist[R] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                    visited[next] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) sb.append(dist[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
