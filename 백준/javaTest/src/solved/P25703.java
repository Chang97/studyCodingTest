package solved;

import java.io.*;

public class P25703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        sb.append("int a;\n");
        sb.append("int *ptr = &a;\n");
        for (int i = 1; i < N; i++) {
            sb.append("int ");
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("ptr").append(i + 1).append(" = &ptr");
            if (i == 1) sb.append(";\n");
            else sb.append(i).append(";\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
