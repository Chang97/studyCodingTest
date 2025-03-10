package 혼자풀기2;

import java.io.*;

public class P11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = n;
        for (long i = 2; i <= Math.sqrt(n); i++) { // 제곱근까지 진행
            if (n % i == 0) { // i가 소인수인지 확인
                result = result - result / i; // result값 업데이트
                while (n % i == 0) { // 소인수 나누기 연산으로 삭제
                    n /= i;
                }
            }
        }
        if (n > 1) { // 아직 소인수 구성이 남아 있는 경우
            // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
            result = result - result / n;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
