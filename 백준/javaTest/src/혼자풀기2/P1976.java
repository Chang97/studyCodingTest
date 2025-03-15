package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] city = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] route = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (city[i][j] == 1) {
                    union(arr,i, j);
                }
            }
        }
        
        int node = find(arr,route[1]);
        for (int i = 2; i <= M; i++) {
            if (node != find(arr,route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    
    static void union(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        
        if (a != b) {
            arr[b] = a;
        }
    }
    
    static int find(int[] arr, int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return find(arr, arr[a]);
        }
    }
}
