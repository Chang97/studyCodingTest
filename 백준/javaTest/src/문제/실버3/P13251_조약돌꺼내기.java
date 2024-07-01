package 문제.실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13251_조약돌꺼내기 {
  public static void main(String[] args) throws IOException {
    int M, K, T;
    int D[] = new int[51];
    double probability[] = new double[51];
    double ans;
    T = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken()); // 색 개수

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      D[i] = Integer.parseInt(st.nextToken()); // 색별 조약돌 개수
      T += D[i];
    }
    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken()); // 뽑는 개수
    ans = 0.0;
    for (int i = 0; i < M; i++) {
      if (D[i] >= K) {
        probability[i] = 1.0;
        for (int k  = 0; k < K; k++) {
          probability[i] *= (double) (D[i] - k) / (T - k);
        }
        ans += probability[i];
      }
    }
    System.out.println(ans);
  }
}
