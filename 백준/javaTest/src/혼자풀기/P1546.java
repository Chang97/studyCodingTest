package 혼자풀기;

import java.util.*;
import java.io.*;
public class P1546 {
    /**
    1. 과목 개수 N을 입력받음
    2. N만큼 각 과목 점수를 입력 받으면 최대값을 찾아서 저장한다.
    3. 각 과목 점수를 점수/최대점수 * 100 으로 변경 후 평균 산출
    4. 위 식은 점수합 / 최대점수 * 100 / 과목수로 표현가능
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum = 0.0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = Double.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            double temp = Double.parseDouble(st.nextToken());
            sum += temp;
            if (max < temp) max = temp;
        }
        System.out.println( sum / max * 100 / N);
        br.close();
    }
}
