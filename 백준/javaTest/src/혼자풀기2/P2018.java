package 혼자풀기2;

import java.io.*;

public class P2018 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int s = 1;
    int e = 1;
    int sum = 1;
    int result = 0;

    while(s <= N) {
      if (sum > N) {
        sum -= s++;
      } else if (sum < N){
        sum += ++e;
      } else {
        result++;
        sum += ++e;
      }
    }

    System.out.println(result);
  }
}
