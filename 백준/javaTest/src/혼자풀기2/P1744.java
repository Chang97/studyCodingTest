package 혼자풀기2;

import java.util.*;
import java.io.*;

public class P1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        int oneCnt = 0;

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 1) oneCnt++;
            else if (val > 0) plus.add(val);
            else minus.add(val);
        }
        
        long result = 0;

        while (minus.size() > 1) {
            int val1 = minus.poll();
            int val2 = minus.poll();
            int x = val1 * val2;
            result += x;
        }
        if (!minus.isEmpty()) result += minus.poll();

        while (plus.size() > 1) {
            int val1 = plus.poll();
            int val2 = plus.poll();
            int x = val1 * val2;
            result += x;
        }
        if (!plus.isEmpty()) result += plus.poll();

        result += oneCnt;

        System.out.println(result);

    } 
}
