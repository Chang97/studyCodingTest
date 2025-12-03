import java.io.*;
import java.util.*;

public class P2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
    
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }
}
