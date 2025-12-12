import java.io.*;
import java.util.*;

public class P2210 {
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};
    static int field[][] = new int[5][5];
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                field[i][j] = num;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, field[i][j], 1);
            }
        }

        System.out.println(set.size());
    }

    static void DFS(int sy, int sx, int curr, int depth) {
        if (depth == 6) {
            set.add(curr);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int ny = sy + dy[k];
            int nx = sx + dx[k];

            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
            int num = curr * 10 + field[ny][nx];
            DFS(ny, nx, num, depth + 1);
        }
    }
}