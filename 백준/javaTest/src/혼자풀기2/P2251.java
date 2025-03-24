package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P2251 {
    static int[] sender = { 0, 0, 1, 1, 2, 2 };
    static int[] reciver = { 1, 2, 0, 2, 0, 1 };
    static boolean[][] visited;
    static boolean[] answer;
    static int size[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = new int[3];

        size[0] = Integer.parseInt(st.nextToken());
        size[1] = Integer.parseInt(st.nextToken());
        size[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) System.out.print(i + " ");
        }
    }

    static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[size[2]] = true;
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = size[2] - A - B; // C는 전체 물의 양에서 A와 B를 뺀것
            for (int k = 0; k < 6; k++) { // A -> B, A ->C, B -> A, B -> C, C -> A, C -> B
                int[] next = { A, B, C };
                next[reciver[k]] += next[sender[k]];
                next[sender[k]] = 0; 
                if (next[reciver[k]] > size[reciver[k]]) { // 물이 넘칠 때
                    next[sender[k]] = next[reciver[k]] - size[reciver[k]]; // 초과하는 만큼 다시 이전 물통에 넣음
                    next[reciver[k]] = size[reciver[k]]; // 대상 물통은 최대로 채워줌
                }

                if (!visited[next[0]][next[1]]) { // A B의 물양으로 방문배열 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
    static class AB {
        int A;
        int B;
        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}

