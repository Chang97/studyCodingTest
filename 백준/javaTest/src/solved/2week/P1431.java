import java.io.*;
import java.util.*;

public class P1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                int asum = 0;
                int bsum = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) - '0' < 10) asum += a.charAt(i) - '0';
                    if (b.charAt(i) - '0' < 10) bsum += b.charAt(i) - '0';
                }
                if (asum == bsum) return a.compareTo(b);
                else return asum - bsum;
            }
        });

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            pq.add(input);
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
