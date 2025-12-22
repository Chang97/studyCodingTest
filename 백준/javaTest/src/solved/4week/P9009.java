import java.io.*;
import java.util.*;

public class P9009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        List<Long> fibonachi = new ArrayList<>();
        fibonachi.add(1L);
        fibonachi.add(2L);
        makeFibonachi(fibonachi, 1);
        
        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            List<Long> answer = new ArrayList<>();
            for (int i = fibonachi.size() - 1; i >= 0; i--) {
                long num = fibonachi.get(i);
                if (num <= n) {
                    answer.add(num);
                    n -= num;
                }
            }
            for (int i = answer.size() - 1; i >= 0; i--) {
                sb.append(answer.get(i)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void makeFibonachi(List<Long> list, int idx) {
        long next = list.get(idx - 1) + list.get(idx);
        if (next > 1000000000) return;
        list.add(next);
        makeFibonachi(list, idx + 1);
    }
}
