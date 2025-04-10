package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[26][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().toCharArray()[0] - 'A';
            int left = st.nextToken().toCharArray()[0] - 'A';
            int right = st.nextToken().toCharArray()[0] - 'A';

            if (left >= 0) arr[parent][0] = left;
            else arr[parent][0] = -1;
            if (right >= 0) arr[parent][1] = right;
            else arr[parent][1] = -1;
            
        }
        preOrder(0);
        bw.write("\n");
        bw.flush();
        inOrder(0);
        bw.write("\n");
        bw.flush();
        postOrder(0);
        bw.write("\n");
        bw.flush();
    }

    static void preOrder(int now) throws IOException {
        if (now == -1) return;
        bw.write((char) (now + 'A'));
        preOrder(arr[now][0]);
        preOrder(arr[now][1]);
    }

    static void inOrder(int now) throws IOException {
        if (now == -1) return;
        inOrder(arr[now][0]);
        bw.write((char) (now + 'A'));
        inOrder(arr[now][1]);
    }

    static void postOrder(int now) throws IOException {
        if (now == -1) return;
        postOrder(arr[now][0]);
        postOrder(arr[now][1]);
        bw.write((char) (now + 'A'));
    }
}
