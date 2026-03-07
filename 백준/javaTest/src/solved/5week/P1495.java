import java.io.*;
import java.util.*;

public class P1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] cur = new boolean[M + 1];
        cur[S] = true;
        for (int i = 1; i <= N; i++) {
            boolean[] next = new boolean[M + 1];
            for (int v = 0; v <= M; v++) {
                if (!cur[v]) continue;

                int up = v + V[i];
                int down = v - V[i];

                if (up <= M) next[up] = true;
                if (down >= 0) next[down] = true;
            }

            cur = next;
        }

        int answer = -1;

        for (int i = M; i >= 0; i--) {
            if (cur[i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
