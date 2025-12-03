import java.io.*;
import java.util.*;

public class P1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Double> stack = new ArrayDeque<>();

        char[] arr = br.readLine().toCharArray();

        long[] num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        for (char c : arr) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                stack.push((double) num[c - 'A']);
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                if (c == '+') stack.push(num2 + num1);
                if (c == '-') stack.push(num2 - num1);
                if (c == '*') stack.push(num2 * num1);
                if (c == '/') stack.push(num2 / num1);
            }
        }
        
        System.out.printf("%.2f%n", stack.pop());
    }
}
