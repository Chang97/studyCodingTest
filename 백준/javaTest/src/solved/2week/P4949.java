import java.io.*;
import java.util.*;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            sb.append(str);
            if (sb.charAt(sb.length() - 1) != '.') {
                sb.append("\n");
            } else {
                Deque<Character> stack = new ArrayDeque<>();
                boolean isOk = true;
                for (char c : sb.toString().toCharArray()) {
                    if (c == '(' || c == '[') {
                        stack.push(c);
                    } else if (c == ')' || c == ']') {
                        if (stack.isEmpty()) {
                            isOk = false;
                            break;
                        }
                        char top = stack.pop();
                        if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                            isOk = false;
                            break;
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    isOk = false;
                }

                if (isOk) bw.write("yes");
                else bw.write("no");
                bw.newLine();
                sb = new StringBuilder();
            }
        }

        bw.flush();
    }
}
