import java.io.*;
import java.util.*;

public class P1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        for (int i = 0; i < L.length(); i++) {
            char cL = L.charAt(i);
            char cR = R.charAt(i);

            if (cL != cR) break;

            if (cL == '8') answer++;
        }

        System.out.println(answer);
    }
}