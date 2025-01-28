package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P1874 {
  /*
   *문제
    스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
    스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

    1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
    이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
    임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
    있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
    이를 계산하는 프로그램을 작성하라.

    입력
    첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 
    둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
    물론 같은 정수가 두 번 나오는 일은 없다.

    출력
    입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. 
    push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
   * 
   */
  /*
   * 풀이
   * N 입력 받음 (연속된숫자 1~N)
   * N 만큼 숫자 배열 생성 (사용된 숫자인지 판별하기 위함)
   * N 만큼 숫자를 입력받음 (num)
   * - num 과 peek 비교
   *   1 num < peek : peek가 num 보다 작아질때까지 pop
   *   2 num > peek : 오름차순 push이니 num 까지 반복하여 사용안한 숫자 있으면 push
   *   3 peek == num : pop  else  NO
  
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    StringBuffer sb = new StringBuffer();

    for (int i = 1; i <= N; i++) {
      int num = Integer.parseInt(br.readLine());
      // peek 가 num 보다 작을때까지 pop
      while (!stack.isEmpty() && stack.peek() > num) {
        stack.pop();
        sb.append("-").append("\n");
      }
      if (max < num) {
        for (int j = max + 1; j <= num; j++) {
          sb.append("+").append("\n");
          stack.push(j);
        }
        max = num;
      }
      

      if (!stack.isEmpty() && stack.peek() == num) {
        stack.pop();
        sb.append("-").append("\n");
      } else {
        System.out.println("NO");
        return;
      }
    }
    System.out.println(sb.toString());
  }
  
}
