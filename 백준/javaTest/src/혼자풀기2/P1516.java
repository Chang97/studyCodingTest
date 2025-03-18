package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1516 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[N + 1];
        int[] degree = new int[N + 1];
        int[] times = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                list[num].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : list[node]) {
                degree[i]--;
                result[i] = Math.max(result[i], result[node] + times[node]);
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + times[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
