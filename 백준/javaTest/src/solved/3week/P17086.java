import java.io.*;
import java.util.*;

public class P17086 {
    static int[][] field;
    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 1) continue;
                boolean[][] visited = new boolean[N][M];
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[] { i, j, 0 });
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int y = cur[0];
                    int x = cur[1];
                    int dist = cur[2];

                    for (int dir = 0; dir < 8; dir++) {
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];

                        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                        if (visited[ny][nx]) continue;

                        int next = dist + 1;
                        if (field[ny][nx] == 1) {
                            if (next > max) max = next;
                            q.clear();
                            break;
                        }
                        visited[ny][nx] = true;
                        q.offer(new int[] { ny, nx, next});

                    }
                }
            }
        }

        System.out.println(max);

    }
}