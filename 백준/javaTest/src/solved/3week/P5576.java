import java.io.*;
import java.util.*;

public class P5576 {
    static List<Integer>[] graph;
    static int[] dist;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        dist[1] = 0;
        q.offer(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            int depth = dist[node];

            if (depth == 2) continue;
            for (int next : graph[node]) {
                if (dist[next] == -1) {
                    q.offer(next);
                    dist[next] = depth + 1;
                    answer++;
                }
            }
        }

        System.out.println(answer); 
    }

}
