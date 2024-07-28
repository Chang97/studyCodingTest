package 혼자풀기;

import java.util.*;
public class P11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 안씀
        int answer = 0;
        String num = sc.next();
        
        if (num.length() == N) {
          for (char c : num.toCharArray()) {
              answer += c - '0';
          }
          System.out.println(answer);
        }
        
        sc.close();
    }
}
