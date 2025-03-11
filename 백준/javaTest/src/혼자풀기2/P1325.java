package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1325 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < answer[i]) max = answer[i];
        }

        for (int i = 1; i <= N; i++) {
            if (answer[i] == max) bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }

    static void BFS(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i : list[idx]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    answer[i]++;
                }
            }
        }
    }
}
