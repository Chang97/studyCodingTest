import java.io.*;
import java.util.*;

public class P24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] arr = new int[N][1];

        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[i][0] == 0) {
                dq.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            dq.addFirst(num);
            sb.append(dq.pollLast()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}