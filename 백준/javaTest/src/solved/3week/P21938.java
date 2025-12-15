import java.io.*;
import java.util.*;

public class P21938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] temp = new int[N][M * 3];
        int[][] field = new int[N][M];
        int[][] visited = new int[N][M];
        int[] dx = { -1, 1, 0, 0};
        int[] dy = { 0, 0, -1, 1};
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M * 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                temp[i][j] = num;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int w = j * 3;
                int avg = (temp[i][w] + temp[i][w + 1] + temp[i][w + 2]) / 3;
                if (avg >= T) field[i][j] = 255;
                else field[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 255) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] { i, j });
                    if (visited[i][j] != 0) continue;
                    answer++;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int y = cur[0];
                        int x = cur[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int ny = y + dy[dir];
                            int nx = x + dx[dir];

                            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                            if (visited[ny][nx] != 0) continue;
                            if (field[ny][nx] == 0) continue;
                            visited[ny][nx] = answer;
                            q.offer(new int[] { ny, nx });
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
