import java.io.*;
import java.util.*;

public class P1120 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) {
                    count++;
                }
            }

            if (min > count) min = count;
        }

        System.out.println(min);

    }
}
