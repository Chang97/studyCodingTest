import java.io.*;
import java.util.*;

public class P28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String type = input.substring(0, 1);

            switch(type) {
                case "1" : 
                    dq.addFirst(Integer.parseInt(input.substring(2)));
                    break;
                case "2" : 
                    dq.addLast(Integer.parseInt(input.substring(2)));
                    break;
                case "3" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollFirst()).append("\n");
                    break;
                case "4" : 
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollLast()).append("\n");
                    break;
                case "5" : 
                    sb.append(dq.size()).append("\n");
                    break;
                case "6" :
                    if (dq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "7" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.getFirst()).append("\n");
                    break;
                case "8" :
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.getLast()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
