package solved;

import java.util.*;
import java.io.*;

public class P15651 {
    static int N;
    static int M;
    static BufferedWriter bw;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        DFS(0);

        bw.flush();
        bw.close();
        
    }

    static void DFS(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            DFS(depth + 1);
        }

    }
}
