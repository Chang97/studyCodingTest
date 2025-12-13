import java.io.*;
import java.util.*;

public class P25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[10000001];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {A, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int val = cur[0];
            int cnt = cur[1];
            if (val > K) continue;
            if (visited[val]) continue;
            visited[val] = true;
            if (val == K) {
                System.out.println(cnt);
                return;
            }
            
            q.offer(new int[] {val * 2, cnt + 1});
            q.offer(new int[] {val + 1, cnt + 1});
        }

    }
}