import java.io.*;
import java.util.*;

public class P4963 {
    static boolean[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int answer = 0;
            field = new boolean[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) field[i][j] = true;
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (field[i][j] && !visited[i][j]) {
                        answer++;
                        BFS(i, j);
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }

    static void BFS(int sy, int sx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];

            for (int dir = 0; dir < 8; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (visited[ny][nx]) continue;
                if (!field[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}
