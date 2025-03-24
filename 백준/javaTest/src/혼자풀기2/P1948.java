package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P1948 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 도로 수
        List<Node>[] list = new ArrayList[n + 1];
        List<Node>[] reverseList = new ArrayList[n + 1];
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            reverseList[b].add(new Node(a, c));
            degree[b]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작도시
        int end = Integer.parseInt(st.nextToken()); // 도착도시

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node i : list[now]) {
                degree[i.next]--;
                result[i.next] = Math.max(result[i.next], result[now] + i.time);
                if (degree[i.next] == 0) {
                    queue.add(i.next);
                }
            }
        }

        int resultCnt = 0;
        boolean visited[] = new boolean[n + 1];
        queue = new ArrayDeque<>();
        queue.add(end);
        visited[end] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node i : reverseList[now]) {
                // 1분도 쉬지 않는 도로 체크
                if (result[i.next] + i.time == result[now]) {
                    resultCnt++;
                    // 중복 카운트 방지를 위해 이미 방문한 적이 있는 노드 제외
                    if (visited[i.next] == false) {
                        visited[i.next] = true;
                        queue.add(i.next);
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(resultCnt);
    }

    static class Node {
        int next;
        int time;

        Node (int next, int time) {
            this.next = next;
            this.time = time;
        }
    }
}
