import java.io.*;
import java.util.*;

public class P10610 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        if (N.indexOf("0") < 0) {
            System.out.println(-1);
            return;
        }

        char[] arr = N.toCharArray();
        int sum = 0;
        for (char c : arr) {
            sum += (c - '0');
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = N.length() - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
