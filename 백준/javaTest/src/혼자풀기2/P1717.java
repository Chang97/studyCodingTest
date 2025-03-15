package 혼자풀기2;

import java.io.*;
import java.util.*;

public class P1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        
        // 초기화 (연결 전 각 노드 대표는 자기 자신)
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gb = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (gb == 0) { // 유니온
                union(arr, a, b);
            } else {
                if (check(arr, a, b)) { // 같은 집한인지 체크
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    
    static void union(int[] arr, int a, int b) { // union : 대표 노드끼리 연결하기
        a = find(arr, a);
        b = find(arr, b);
        if (a != b) {
            arr[b] = a;
        }
    }
    
    static int find(int[] arr, int a) {
        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr,arr[a]);
        }
    }
    
    static boolean check(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
        
        
}
