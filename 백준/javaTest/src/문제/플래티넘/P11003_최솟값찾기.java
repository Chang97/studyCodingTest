package 문제.플래티넘;

/*
 * 1. 첫째줄에서 N과 L 입력 받기
 * 2. 둘째줄에서 N개의 수의 A 입력받기
 * 3. 덱을 이용해 최소값 구하기
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class P11003_최솟값찾기{
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Deque<Node> deque = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      //  새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
      int now = Integer.parseInt(st.nextToken());

      // 덱을 뒤에서 부터 탐색해 현재 입력값 보다 큰 수가 들어있으면 삭제
      while (!deque.isEmpty() && deque.getLast().value > now) {
        deque.removeLast();
      }

      // 입력값 덱에 추가
      deque.addLast(new Node(now, i));

      // 범위에서 벗언난 값은 덱에서 제거
      if (deque.getFirst().index <= i - L) {
        deque.removeFirst();
      }
      bw.write(deque.getFirst().value + " ");
    }
    bw.flush();
    br.close();

    
  }
  static class Node {
    public int value;
    public int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
