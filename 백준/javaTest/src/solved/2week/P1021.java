import java.io.*;
import java.util.*;

public class P1021 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) dq.add(i);

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = 0;
            int size = dq.size();
            for (Object val : dq.toArray()) {
                if ((int) val == num) break;
                index++;
            }

            if (index < size - index) {
                while (dq.peekFirst() != num) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                while (dq.peekFirst() != num) {
                    dq.addFirst(dq.pollLast());
                }
            }
            dq.poll();
            answer += Math.min(index, size - index);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
