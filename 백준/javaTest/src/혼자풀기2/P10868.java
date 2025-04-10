package 혼자풀기2;

import java.io.*;
import java.util.*;
public class P10868 {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafNodeIndex = treeSize / 2 - 1;
        tree = new int[treeSize + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = leafNodeIndex + 1; i <= leafNodeIndex + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(getMin(s + leafNodeIndex, e+ leafNodeIndex));
        }

    }
    static int getMin(int start, int end) {
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                min = Math.min(tree[start], min);
                start++;
            }
            start = start / 2;
            if (end % 2 == 0) {
                min = Math.min(tree[end], min);
                end--;
            }
            end = end / 2;
        }
        return min;
    }
    static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = Math.min(tree[i], tree[i / 2]);
            i--;
        }
    }
}
