package 문제.골드4;

import java.io.*;
import java.util.*;
public class P17298_오큰수 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 수열 개수 N을 입력 받는다.
    int n = Integer.parseInt(br.readLine());
    // 수열 배열, 정답 배열 생성
    int[] A = new int[n];
    int[] ans = new int[n];
    // 수열 배열 입력 받기
    String[] str = br.readLine().split(" ");
    // 형 변환하여 A 배열에 복사
    for (int i = 0; i < str.length; i++) {
      A[i] = Integer.parseInt(str[i]);
    }

    // 배열 index를 보관할 스택 생성
    Stack<Integer> stack = new Stack<>();

    // 최초 스택 초기화
    stack.push(0);

    // A 배열을 순회하며 스택 peek인덱스와 값 비교
    for (int i = 1; i < n; i++) {
      // 스택 A[peek] < A[i] 이면 A[i] 가 오큰수이기 때문에 정답 배열에 추가
      // 계속 pop하며 A[i] 와 비교
      while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
        ans[stack.pop()] = A[i];
      }
      // 스택에 현재 인덱스 삽입
      stack.push(i);
    }

    // 위 작업이 끝나고 stack이 비어있지 않은 경우 처리
    while (!stack.isEmpty()) {
      ans[stack.pop()] = -1;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < n; i++) {
      bw.write(ans[i] + " ");
    }
    bw.flush();
    br.close();

  }
  
}