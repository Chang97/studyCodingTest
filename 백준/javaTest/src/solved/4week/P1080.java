import java.io.*;
import java.util.*;

public class P1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] source = new int[N][M];
        int[][] target = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                source[i][j] = input[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                target[i][j] = input[j] - '0';
            }
        }

        if (N < 3 || M < 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (source[i][j] != target[i][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (source[i][j] != target[i][j]) {
                    if (i + 2 < N && j + 2 < M) {
                        cnt++;
                        for (int k = i; k < i + 3; k++) {
                            for (int l = j; l < j + 3; l++) {
                                source[k][l] = source[k][l] == 1 ? 0 : 1;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (source[i][j] != target[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }
}
