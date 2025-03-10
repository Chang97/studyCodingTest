package 혼자풀기2;

import java.io.*;
import java.util.*;

// 질량을 모두 더한값은 최소
// 총 질량 0 보다 커야함. 정수
// a b p q 와 같은 형식, a번 재료의 질량을 b번 재료의 질량으로 나눈 값이 p / q
public class P1033 {
    static long lcm = 1;
    static boolean[] visited;
    static long D[];
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

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
            list[a].add(new Node(b, p, q));
            list[b].add(new Node(a, q, p));

            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(D[i] / mgcd + " ");
        }
        
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
                D[next] = D[n] * node.q / node.p;
                DFS(next);
            }
        }
    }

    static class Node {
        int b;
        int p;
        int q;
    
        Node (int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }

}
