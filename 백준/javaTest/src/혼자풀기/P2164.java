package 혼자풀기;

import java.util.*;
public class P2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        boolean isDrop = true;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        while (queue.size() > 1) {
            answer = queue.poll();
            if (isDrop) {
              isDrop = false;
            } else {
              queue.add(answer);
              isDrop = true;
            }
        }
        
        System.out.println(queue.poll());
        sc.close();
    }
}
