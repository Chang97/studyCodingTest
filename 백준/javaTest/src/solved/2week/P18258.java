import java.io.*;

public class P18258 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int front = 0;
        int back = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("pop")) {
                if (back - front == 0) sb.append(-1).append("\n");
                else sb.append(arr[front++]).append("\n");
            } else if (input.equals("size")) {
                sb.append(back - front).append("\n");
            } else if (input.equals("empty")) {
                if (back - front == 0) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (input.equals("front")) {
                if (back - front == 0) sb.append(-1).append("\n");
                else sb.append(arr[front]).append("\n");
            } else if (input.equals("back")) {
                if (back - front == 0) sb.append(-1).append("\n");
                else sb.append(arr[back - 1]).append("\n");
            } else {
                int num = Integer.parseInt(input.substring(5));
                arr[back++] = num;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
