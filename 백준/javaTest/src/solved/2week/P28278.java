import java.io.*;

public class P28278 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];
        int top = -1;
        for (int t = 0; t < N; t++) {
            String input = br.readLine();

            if (input.equals("2")) {
                if (top < 0) sb.append(-1).append("\n");
                else sb.append(stack[top--]).append("\n");
            } else if (input.equals("3")) {
                sb.append(top + 1).append("\n");
            } else if (input.equals("4")) {
                if (top < 0) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (input.equals("5")) {
                if (top < 0) sb.append(-1).append("\n");
                else sb.append(stack[top]).append("\n");
            } else {
                int num = Integer.parseInt(input.substring(2));
                stack[++top] = num;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
