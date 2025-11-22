import java.io.*;
import java.util.*;

public class P2960 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[1001];
        
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (check[j]) continue;
                check[j] = true;
                if (++cnt == K) {
                    bw.write(String.valueOf(j));
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }
    }
}
