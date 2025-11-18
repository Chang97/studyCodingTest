import java.io.*;
import java.util.*;

public class P1476 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 1;

        int e = 1;
        int s = 1;
        int m = 1;
        while (!(e == E && s == S && m == M)) {

            if (e == 15) e = 1;
            else e++;
            
            if (s == 28) s = 1;
            else s++;
            
            if (m == 19) m = 1;
            else m++;

            answer++;
            
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}
