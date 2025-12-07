import java.io.*;
import java.util.*;

public class P2606 {
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        DFS(1);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) answer++;
        }

        System.out.println(answer - 1);

    }

    static void DFS(int node) {
        visited[node] = true;

        for (int next : list[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
