package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P1920 {
    /*
     *  문제
        N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

        입력
        첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
        다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
        다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
        다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
        모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

        출력
        M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
     */
    /*
     * 풀이
     * 100,000 * 100,000 범위가 커 nlogn 알고리즘 이진탐색으로 풀어야함
     * 일단 입력받은 데이터를 정렬
     * 이진 탐색으로 하나씩 찾으며 없으면 0 있으면 1출력
     */
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        long[] fArr = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            fArr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            boolean yn = binarySearch(arr, 0, arr.length - 1, fArr[i]);
            if (yn) System.out.println("1");
            else System.out.println("0");

        }

    }
    
    static boolean binarySearch(long[] arr, int s, int e, long findNum) {
        if (s > e) return false;
        int m = (s + e) / 2;
        if (arr[m] > findNum) {
            return binarySearch(arr, s, m - 1, findNum);
        } else if (arr[m] < findNum) {
            return binarySearch(arr, m + 1, e, findNum);
        } else {
            return true;
        }
    }
}