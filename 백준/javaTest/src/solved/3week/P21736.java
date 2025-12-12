import java.io.*;
import java.util.*;

public class P21736 {
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0 , 0};
    static int[] dy = { 0, 0, -1 , 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        field = new char[N][M];
        visited = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                field[i][j] = line[j];
                if (field[i][j] == 'I') q.offer(new int[] { i, j });
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (visited[ny][nx]) continue;
                if (field[ny][nx] == 'X') continue;
                if (field[ny][nx] == 'P') answer++;
                visited[ny][nx] = true;
                q.offer(new int[] { ny, nx });
            }
        }

        if (answer == 0) System.out.println("TT");
        else System.out.println(answer);

    }
}
