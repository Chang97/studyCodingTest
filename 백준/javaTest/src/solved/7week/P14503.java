import java.util.*;
import java.io.*;
public class P14503 {
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int[][] arr;
    static boolean[][] clear;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        clear = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            if (!clear[r][c]) {
                clear[r][c] = true;
                answer++;
            }

            boolean chk = false;
            for (int i = 0; i < 4; i++) {
                int y = dy[i] + r;
                int x = dx[i] + c;
                if (y < 0 || y >= N || x >= M || x < 0) continue;
                if (arr[y][x] == 1) continue;
                if (clear[y][x]) continue;
                chk = true;
                break;
            }

            if (chk) {
                spin();
            } else {
                if (!moveBack()) break;
            }
        }

        System.out.println(answer);
    }

    static void spin() {
        if (d == 0) {
            d = 3;
            if (c - 1 >= 0 && arr[r][c - 1] == 0 && !clear[r][c - 1]) c--;
        } else if (d == 1) {
            d--;
            if (r - 1 >= 0 && arr[r - 1][c] == 0 && !clear[r - 1][c]) r--;
        } else if (d == 2) {
            d--;
            if (c + 1 < M && arr[r][c + 1] == 0 && !clear[r][c + 1]) c++;
        } else if (d == 3) {
            d--;
            if (r + 1 < N && arr[r + 1][c] == 0 && !clear[r + 1][c]) r++;
        }
    }

    static boolean moveBack() {
        if (d == 0) {
            if (r + 1 < N && arr[r + 1][c] == 0) {
                r++;
                return true;
            } else {
                return false;
            }
        } else if (d == 1) {
            if (c - 1 > 0 && arr[r][c - 1] == 0) {
                c--;
                return true;
            } else {
                return false;
            }
        } else if (d == 2) {
            if (r - 1 > 0 && arr[r - 1][c] == 0) {
                r--;
                return true;
            } else {
                return false;
            }
        } else {
            if (c + 1 < M && arr[r][c + 1] == 0) {
                c++;
                return true;
            } else {
                return false;
            }
        }
    }
}
