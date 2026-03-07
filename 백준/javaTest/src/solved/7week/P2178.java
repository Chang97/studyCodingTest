import java.util.*;
import java.io.*;
public class P2178 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];
        
        for (int i = 1; i <= N; i++) {
        char[] cArr = br.readLine().toCharArray();
        for (int j = 1; j <= M; j++) {
            arr[i][j] = cArr[j - 1] - '0';
        }
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 1, 1));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int py = cur.y;
            int px = cur.x;
            int dist = cur.dist;
            if (py == N && px == M) {
                System.out.println(dist);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int y = dy[i] + py;
                int x = dx[i] + px;
                if (x < 1 || x > M || y < 1 || y > N) continue;
                if (arr[y][x] == 0) continue;
                if (visited[y][x]) continue;
                visited[y][x] = true;
                q.add(new Node(y, x, dist + 1));
            }
        }
    }

    static class Node {
        int y;
        int x;
        int dist;

        Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
        }
    }
}
