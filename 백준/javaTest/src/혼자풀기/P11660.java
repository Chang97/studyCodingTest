package 혼자풀기;

import java.util.*;
import java.io.*;

public class P11660 {
    /*
    1. N 과 M을 입력 받는다.
    2. N * N 모양으로 입력
    3. 2차원 배열 부분합 구하기
    - 부분합 공식 : sumSq[i][j] = sumSq[i][j - 1] + sumSq[i - 1][j] - sumSq[i - 1][j - 1] + sq[i][j];
    (왼쪽, 위에는 더하고 왼쪽 대각선위는 뺀다)
    4. M만큼 4개 좌표 받아서 합 출력
    - 부분합 값 도출 공식
    sumSq[x2][y2] - sumSq[x1 - 1][y2] - sumSq[x2][y1 - 1] + sumSq[x1 - 1][y1 - 1]
    (최하단 기준 왼쪽 끝 한칸 더 왼쪽 , 위쪽 끝 한칸 위에 값은 빼고 대각선 끝에서 i - 1, j - 1 좌표는 더함)
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] sq = new int[N + 1][N + 1];
        int[][] sumSq = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sq[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumSq[i][j] = sumSq[i][j - 1] + sumSq[i - 1][j] - sumSq[i - 1][j - 1] + sq[i][j];
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sumSq[x2][y2] - sumSq[x1 - 1][y2] - sumSq[x2][y1 - 1] + sumSq[x1 - 1][y1 - 1]);
        }
        
    }
}
