
import java.io.*;
import java.util.*;
public class P10828 {
    
    public static void main (String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int t = 0; t < N; t++) {
            String str = br.readLine();

            if (str.equals("pop")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.pop() + "\n");
            } else if (str.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (str.equals("empty")) {
                if (stack.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            } else if (str.equals("top")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.peek() + "\n");
            } else { // push
                int num = Integer.parseInt(str.replaceAll("push ", ""));
                stack.push(num);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
