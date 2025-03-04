package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P1931 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
          
        });
        int result = 1;
        int end = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (end <= arr[i][0]) {
              result++;
              end = arr[i][1];
            }
        }

        System.out.println(result);


    }
}
