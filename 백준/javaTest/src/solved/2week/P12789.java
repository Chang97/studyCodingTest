import java.io.*;
import java.util.*;

public class P12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        int curr = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == curr + 1) {
                curr = stack.pop();
            }
        }
        if (curr == N) System.out.println("Nice");
        else System.out.println("Sad");
        
    }
}
