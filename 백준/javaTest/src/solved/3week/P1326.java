import java.io.*;
import java.util.*;

public class P1326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] field = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { a, 0 });
        visited[a] = true;

        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int cnt = cur[1];
            int val = field[idx];
            if (idx == b) {
                answer = cnt;
                break;
            }

            int r = idx;
            while (r <= N) {
                r += val;
                if (r > N) continue;
                if (visited[r]) continue;
                visited[r] = true;
                q.offer(new int[] { r, cnt + 1 } );
            }
            r = idx;
            while (r > 0) {
                r -= val;
                if (r <= 0) continue;
                if (visited[r]) continue;
                visited[r] = true;
                q.offer(new int[] { r, cnt + 1 } );
            }
        }

        if (answer > 0) System.out.println(answer);
        else System.out.println(-1);

    }
}