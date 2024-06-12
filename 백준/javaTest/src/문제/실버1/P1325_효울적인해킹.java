package 문제.실버1;

import java.io.*;
import java.util.*;

public class P1325_효울적인해킹 {
    static int N, M;
    static ArrayList<Integer>[] reverseGraph;
    static boolean[] visited;
    static int[] hackCount;

    // BFS를 사용하여 역방향 그래프 탐색
    public static int bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : reverseGraph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            reverseGraph[B].add(A); // 역방향으로 그래프를 저장
        }

        hackCount = new int[N + 1];
        int maxHack = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            hackCount[i] = bfs(i);
            maxHack = Math.max(maxHack, hackCount[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackCount[i] == maxHack) {
                result.append(i).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}