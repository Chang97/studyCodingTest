package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11725 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();


    }

    static void DFS(int parent) {
        List<Integer> s = list[parent];
        visited[parent] = true;
        for (int i : s) {
            if (visited[i]) continue;
            arr[i] = parent;
            DFS(i);
        }
    }
}
