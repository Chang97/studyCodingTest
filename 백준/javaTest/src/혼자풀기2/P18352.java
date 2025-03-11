package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P18352 {
    static int N, M, K, X;
    static List<Integer>[] list; // 인접리스트
    static int[] visited; // 방문배열 (최단거리도 함께 저장)
    static List<Integer> answer; // 정답 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시

				// 초기화
        list = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        BFS(X);
        answer = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
		        // X부터 이동거리가 K인 노드
            if (visited[i] == K) answer.add(i);
        }

        if (answer.isEmpty()) System.out.println("-1");
        else Collections.sort(answer);
        for (int num : answer) {
            System.out.println(num);
        }


    }

    static void BFS(int x)  {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;
        while (!queue.isEmpty()) {
            int idx = queue.poll();

            for (int i : list[idx]) {
                if (visited[i] == -1) { // 방문하지 않은 경우
                    visited[i] = visited[idx] + 1; // 거리 추가
                    queue.add(i);
                }
            }
        }
    }
}
