import java.util.*;
import java.io.*;

public class P1244 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] switchs = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = num; i <= N; i +=num) {
                    switchs[i] = switchs[i] == 0 ? 1 : 0;
                }
            } else {
                switchs[num] = switchs[num] == 0 ? 1 : 0;
                int cnt = 1;
                while (num - cnt > 0 && num + cnt <= N) {
                    if (switchs[num - cnt] == switchs[num + cnt]) {
                        switchs[num - cnt] = switchs[num - cnt] == 0 ? 1 : 0;
                        switchs[num + cnt] = switchs[num + cnt] == 0 ? 1 : 0;
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(switchs[i] + " ");
            if (i % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
