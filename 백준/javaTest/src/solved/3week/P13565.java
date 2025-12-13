import java.io.*;
import java.util.*;

public class P13565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        boolean[][] field = new boolean[M][N];
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) if (arr[j] == '0') field[i][j] = true;
        }

        for (int i = 0; i < N; i++) {
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[] { 0, i });

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                    if (visited[ny][nx]) continue;
                    if (!field[ny][nx]) continue;

                    visited[ny][nx] = true;
                    q.offer(new int[] { ny, nx });
                }
            }
        }

        boolean answer = false;

        for (int i = 0; i < N; i++) {
            if (visited[M - 1][i]) {
                answer = true;
                break;
            }
        }

        if (answer) System.out.println("YES");
        else System.out.println("NO");
        
    }
}