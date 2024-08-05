package 혼자풀기;

import java.util.*;
public class P11286 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                return o1 > o2 ? 1 : -1;
            } else {
                return abs1 - abs2;
            }
        });
        
        int N = sc.nextInt();
        
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
        sc.close();
    }
}
