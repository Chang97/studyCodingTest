package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1068 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    static int delNode;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        visited = new boolean[N];
        parent = new int[N];
        int start = 0;

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val == -1) {
                start = i;
            } else {
                parent[i] = val;
                list[val].add(i);
                list[i].add(val);
            }
        }

        delNode = Integer.parseInt(br.readLine());
        if (delNode == start) { // 루트를 삭제하는 경우
            System.out.println(0);
        } else {
            DFS(start);
            System.out.println(result);
        }
    }

    static void DFS(int start) {
        List<Integer> now = list[start];
        visited[start] = true;
        boolean isLeaf = true;
        for (int child : now) {
            if (visited[child]) continue;
            if (child == delNode) continue;
            DFS(child);
            isLeaf = false;
        }
        if (isLeaf) result++;
    }
}
