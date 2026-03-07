import java.io.*;
import java.util.*;

public class P12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(w, v));
        }

        int[] dp = new int[K + 1];
        
        for (Node cur : list) {
            int w = cur.w;
            int v = cur.v;

            for (int i = K; i >= w; i--) {
                dp[i] = Math.max(dp[i], dp[i - w] + v);
            }
        }

        System.out.println(dp[K]);
    }

    static class Node {
        int w;
        int v;

        Node (int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
