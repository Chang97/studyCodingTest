package 혼자풀기2;

import java.io.*;
import java.util.*;

// 질량을 모두 더한값은 최소
// 총 질량 0 보다 커야함. 정수
// a b p q 와 같은 형식, a번 재료의 질량을 b번 재료의 질량으로 나눈 값이 p / q
public class P1033 {
    static long lcm = 1; // 최소공배수
    static boolean[] visited; // 방문여부
    static long D[]; //각 노드값
    static List<Node>[] list; // 인접리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
				// 초기화
        list = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++){ 
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            // 에지 정보 저장
            list[a].add(new Node(b, p, q));
            list[b].add(new Node(a, q, p));
						// 최소공배수 업데이트
            lcm *= (p * q / gcd(p, q));
        }
	      // 0번노드에 최소 공배수 저장하고 DFS탐색
        D[0] = lcm;
        DFS(0);
        // 최대 공약수계산
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(D[i] / mgcd + " ");
        }
        bw.flush();
        bw.close();
        
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static void DFS(int n) {
        visited[n] = true;
        for (Node node : list[n]) {
            int next = node.b;
            if (!visited[next]) {
                D[next] = D[n] * node.q / node.p; // 현재노드값 * 비율
                DFS(next);
            }
        }
    }

    static class Node {
        int b; // 다음 노드
        int p; // 비율 p
        int q; // 비율 q
    
        Node (int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }

}
