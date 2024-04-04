
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] numArr = new int[N + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      numArr[i] = numArr[i - 1] + Integer.parseInt(st.nextToken());
    }
    int[] answer = new int[M];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int sNum = Integer.parseInt(st.nextToken());
      int eNum = Integer.parseInt(st.nextToken());
      answer[i] = numArr[eNum] - numArr[sNum - 1];
    }

    for (int i : answer) {
      System.out.println(i);
    }
  }
}
