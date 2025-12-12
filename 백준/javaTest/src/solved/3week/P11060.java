import java.io.*;
import java.util.*;

public class P11060 {
    static int[] field;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        field = new int[N];
        visited = new int[N];
        Arrays.fill(visited, -1);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            field[i] = num;
        }

        Queue<int[]> q = new ArrayDeque<>();

        // 필드값, index, 점프횟수
        q.offer(new int[] {field[0], 0, 0});
        visited[0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int val = cur[0];
            int index = cur[1];
            for (int i = index + val; i > index; i--) {
                int next = i;
                if (next >= N) next = N - 1;
                if (visited[next] != -1) continue;
                visited[next] = cur[2] + 1;
                q.offer(new int[] {field[next], next, cur[2] + 1});
            }
        }

        if (visited[N - 1] != -1) System.out.println(visited[N - 1]);
        else System.out.println(-1);
    }
}