import java.io.*;
import java.util.*;

public class P17413 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        boolean isOpen = false;
        StringBuilder temp = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '<') {
                isOpen = true;
                if (temp.length() > 0) {
                    sb.append(temp.reverse()).append(c);
                    temp = new StringBuilder();
                    continue;
                }
            } else if (c == '>') {
                isOpen = false;
                sb.append(c);
                continue;
            } else if (!isOpen && c == ' ') {
                if (temp.length() > 0) {
                    sb.append(temp.reverse()).append(c);
                    temp = new StringBuilder();
                    continue;
                }
            }

            if (isOpen) sb.append(c);
            else temp.append(c);
            
        }

        if (temp.length() > 0) sb.append(temp.reverse());

        bw.write(sb.toString());
        bw.flush();
    }
}
