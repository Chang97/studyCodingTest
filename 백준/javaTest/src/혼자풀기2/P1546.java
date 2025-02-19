package 혼자풀기2;

import java.io.*;
import java.util.StringTokenizer;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 과목수

        double[] score = new double[N];
        double max = 0;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 과목별 점수를 입력 받으며 최대값과 합계를 구한다.
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            sum += score[i];
            if (max < score[i]) max = score[i];
        }

        // 문제에 나온 계산식을 적용하여 평균 구함
        System.out.println(sum * 100 / max / N);
    }
}
