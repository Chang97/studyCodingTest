import java.io.*;
import java.util.*;

public class P7568 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] rank = new int[N];
        int[][] info = new int[2][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[0][i] = Integer.parseInt(st.nextToken());
            info[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (info[0][i] < info[0][j] && info[1][i] < info[1][j]) rank[i]++;
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(rank[i] + 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
