import java.io.*;
import java.util.*;

public class P3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int t = 0; t < N; t++) {
            Deque<Character> stack = new ArrayDeque<>();
            String input = br.readLine();

            for (char c : input.toCharArray()) {
                if (!stack.isEmpty()) {
                    if (stack.getFirst() == c) {
                        stack.pollFirst();
                        continue;
                    }
                }
                stack.addFirst(c);
            }

            if (stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}
