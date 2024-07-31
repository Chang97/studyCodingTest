package 혼자풀기;

import java.util.*;
import java.io.*;

public class P1874 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(br.readLine());
            
            while (true) {
                if (!stack.isEmpty()) {
                  if (stack.peek() == now) {
                      stack.pop();
                      sb.append("-\n");
                      break;
                  } else if (stack.peek() < now && cnt <= N) {
                      stack.push(cnt++);
                      sb.append("+\n");
                  } else {
                      System.out.println("NO");
                      return;
                  }
                } else {
                  if (cnt <= N) {
                      stack.push(cnt++);
                      sb.append("+\n");
                  }
                }
            }
        }
        System.out.println(sb.toString());
        br.close();
        
    }
}