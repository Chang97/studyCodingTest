import java.io.*;
import java.util.*;

public class P4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while (true) {
            String input = br.readLine();

            if (input.indexOf("-") != -1) break;

            Deque<Character> stack = new ArrayDeque<>();
            int answer = 0;
            for (char c : input.toCharArray()) {
                if (c == '{') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push('{');
                        answer++;
                    }
                }
            }

            sb.append(++cnt).append(". ").append(answer + (stack.size() / 2)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
