import java.io.*;
import java.util.*;

public class P11656 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String[] arr = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }
}
