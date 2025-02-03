package 혼자풀기2;

import java.util.*;
import java.io.*;
public class P1377 {
  /*
    문제
    버블 소트 알고리즘을 다음과 같이 C++로 작성했다.

    bool changed = false;
    for (int i=1; i<=N+1; i++) {
        changed = false;
        for (int j=1; j<=N-i; j++) {
            if (A[j] > A[j+1]) {
                changed = true;
                swap(A[j], A[j+1]);
            }
        }
        if (changed == false) {
            cout << i << '\n';
            break;
        }
    }
    위 소스에서 N은 배열의 크기이고, A는 정렬해야 하는 배열이다. 배열은 A[1]부터 사용한다.

    위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구해보자.

    입력
    첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.

    출력
    정답을 출력한다.
   */
  /*
   풀이
   주어진 배열에서 버블소트 시 swap이 발생하는 횟수를 구해야함
   일반적인 버블소트로는 시간초과가 발생하여 다르게 접근해야함
   오름차순 정렬 후 정렬 전 인덱스와 변경 후 인덱스를 차를 구한 후 
   swap이 일어나지 않는 반복문이 한 번 더 실행되는 것을 감안해 최대값의 + 1 한 값이 swap 횟수가 된다.
   */
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    List<Node> list = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      int val = Integer.parseInt(br.readLine());
      list.add(new Node(i, val));
    }

    Collections.sort(list);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      int val = list.get(i).index - (i + 1);
      if (max < val) {
        max = val;
      }
    }

    System.out.println(max + 1);
  }

  static class Node implements Comparable<Node>{
    int index;
    int value;
  
    Node (int index, int value) {
      this.index = index;
      this.value = value;
    }
  
    @Override
    public int compareTo(Node node) {
      return this.value - node.value;
    }
  }
}


