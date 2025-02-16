package 혼자풀기2;

import java.io.*;
public class P11720 {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // 입력은 받지만 사용은 안함.
      int N = Integer.parseInt(br.readLine());
      char[] arr = br.readLine().toCharArray(); // 입력받은 문자열을 char[]로 변환

      int sum = 0; // 합계를 저장할 변수
      for (char c : arr) {
          sum += c - '0'; // 숫자로 변환해서 sum에 추가
      }

      System.out.println(sum);
    }
}
