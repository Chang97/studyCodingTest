package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        long[] distance = new long[N];
        int[] money = new int[N];
        Arrays.fill(distance, Long.MIN_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, v);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        distance[sCity] = money[sCity];

        for (int i = 0; i <= N + 100; i++) { // 양수사이클이 전파되도록 충분히 큰 수로 반복
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                // 출발 노드가 방문하지 않은 노드면 skip
                if (distance[edge.start] == Long.MIN_VALUE) continue;
                // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결노드로 업데이트
                else if (distance[edge.start] == Long.MAX_VALUE) distance[edge.end] = Long.MAX_VALUE;
                // 더 많은 돈을 벌 수 있는 경로가 발견되면 업데이트
                else if (distance[edge.end] < distance[edge.start] + money[edge.end] - edge.value) {
                    distance[edge.end] = distance[edge.start] + money[edge.end] - edge.value;
                    // N - 1번 반복 이후 업데이트되는 종료 노드는 양수 사이클 노드로 변경
                    if (i >= N - 1) distance[edge.end] = Long.MAX_VALUE;
                }
            }
        }
        if (distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if (distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }

    static class Edge {
        int start;
        int end;
        int value;

        Edge (int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

}
