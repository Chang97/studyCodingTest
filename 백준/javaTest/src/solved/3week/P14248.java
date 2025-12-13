import java.io.*;
import java.util.*;

public class P14248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] field = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);

        while (!q.isEmpty()) {
            int idx = q.poll();
            int val = field[idx];
            visited[idx] = true;

            int left = idx - val;
            int right = idx + val;

            if (left > 0 && !visited[left]) q.offer(left);
            if (right <= n && !visited[right]) q.offer(right);

        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) answer++;
        }

        System.out.println(answer);



    }
}