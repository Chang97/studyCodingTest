import java.io.*;
import java.util.*;

public class P1475 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] set = new int[10];
        for (int i = 0; i < 10; i++) set[i] = 1;
        int answer = 1;
        for (char c : arr) {
            int num = c - '0';
            if (num == 6) {
                if (set[num] == 0 && set[9] > 0) {
                    set[9]--;
                    continue;
                }
            } else if (num == 9) {
                if (set[num] == 0 && set[6] > 0) {
                    set[6]--;
                    continue;
                }
            }

            if (set[num] == 0) {
                for (int i = 0; i < 10; i++) set[i]++;
                answer++;
            }
            set[num]--;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
