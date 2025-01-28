package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P11003 {
  /*
   *문제
    N개의 수 A1, A2, ..., AN과 L이 주어진다.

    Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

    입력
    첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)

    둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)

    출력
    첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
   */
  /*
   * 풀이
   * 정렬을 사용할시 시간초과이므로 데크를 활용하여 최소값을 구하는 방법으로 풀이
   * 값을 비교하여 새로 입력받은 value보다 큰 값이 앞에 있으면 해당 값 제거하는식으로
   * 정렬된 구조를 유지하며 진행, 인덱스를 비교하여 L범위를 준수하는지 확인하며
   * 초과하는경우 first제거
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    // long[] arr = new long[N];
    st = new StringTokenizer(br.readLine());
    
    Deque<Node> dq = new LinkedList<>();

    dq.addFirst(new Node(1, Long.parseLong(st.nextToken())));
    sb.append(dq.peekFirst().value).append(" ");
    for (int i = 1; i < N; i++) {
      long value = Long.parseLong(st.nextToken());
      Node node = new Node(i + 1, value);
      if (!dq.isEmpty()) {
        while (!dq.isEmpty() && dq.peekLast().value > value) {
          dq.pollLast();
        }

        dq.addLast(node);

        if (dq.getLast().index - dq.getFirst().index >= L) {
          dq.pollFirst();
        }
      }
      sb.append(dq.peekFirst().value).append(" ");
    }
    System.out.println(sb.toString());
  }
}

class Node {
  int index;
  long value;

  Node(int index, long value) {
    this.index = index;
    this.value = value;
  }
}
