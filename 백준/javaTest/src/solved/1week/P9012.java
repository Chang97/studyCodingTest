

import java.io.*;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            char[] str = br.readLine().toCharArray();
            int n = 0;

            for (char c : str) {
                if (c == '(') {
                    n++;
                } else {
                    n--;
                }
                if (n < 0) break;
            }
            if (n == 0) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
