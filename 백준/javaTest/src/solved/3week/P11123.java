import java.io.*;
import java.util.*;

public class P11123 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int cnt = 0;
            boolean[][] field = new boolean[H][W];
            int[][] visited = new int[H][W];

            for (int i = 0; i < H; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if (arr[j] == '#') field[i][j] = true;
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visited[i][j] != 0 || !field[i][j]) continue;
                    cnt++;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int y = cur[0];
                        int x = cur[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int ny = y + dy[dir];
                            int nx = x + dx[dir];

                            if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                            if (visited[ny][nx] != 0) continue;
                            if (!field[ny][nx]) continue;
                            visited[ny][nx] = cnt;
                            q.offer(new int[] { ny, nx });
                        }

                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        
    }
}