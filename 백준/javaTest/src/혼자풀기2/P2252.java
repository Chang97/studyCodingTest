package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P2252 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[N + 1];
        int[] degree = new int[N + 1];
        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            degree[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            bw.write(num + " ");
            for (int i : list[num]) {
                if (--degree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
