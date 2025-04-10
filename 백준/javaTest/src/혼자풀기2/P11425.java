package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P11425 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Node now = root;
            
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node();
                }
                now = now.next[c - 'a'];
                if (j == str.length() - 1) {
                    now.isEnd = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            Node now = root;
            
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if (j == str.length() - 1 && now.isEnd) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }

}
