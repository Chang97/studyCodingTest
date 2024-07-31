package 혼자풀기;

import java.util.*;
import java.io.*;
public class P11003 {
    /*
    슬프게도 문제 자체가 이해가 안됨
    입력값만 따라 받아보자..
    1. N L을 입력받음
    2. N만큼 입력받음
    3. 일정 범위만큼에서 최소값을 구하는것이니 슬라이딩 윈도우와 정렬을 사용, 슬라이딩 윈도우를 덱으로 구현하여 정렬 효과를 볼 수 있음
    4. 데크 ㄱㄱ
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Deque<Node> myDeque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            
            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(now, i));
            // 범위에서 벗어난 값은 덱에서 제거
            if (myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    int value;
    int index;
    
    public Node (int value, int index) {
        this.value = value;
        this.index = index;
    }
    
}
