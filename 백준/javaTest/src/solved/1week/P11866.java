
import java.io.*;
import java.util.*;

public class P11866 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] out = new boolean[N + 1];
        int curr = 1;
        int cnt = 0;
        int use = 0;
        bw.write("<");
        while (use < N) {
            if (!out[curr]) {
                cnt++;
                if (cnt == K) {
                    out[curr] = true;
                    cnt = 0;
                    use++;
                    if (use == N) {
                        bw.write(String.valueOf(curr));
                    } else {
                        bw.write(String.valueOf(curr) + ", ");
                    }
                }
            }
            
            curr++;
            if (curr > N) curr = 1;
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();

    }   
}
