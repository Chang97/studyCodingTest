import java.io.*;

public class P1436 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int i = 666;
        while (true) {
            String str = String.valueOf(i);
            if (str.indexOf("666") != -1) cnt++;
            if (cnt == N) {
                bw.write(String.valueOf(i));
                break;
            }
            i++;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
